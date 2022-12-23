package GwenShop.com.controller;

import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Users;
import org.apache.commons.beanutils.BeanUtils;
import GwenShop.com.util.Constants;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = {"/login", "/sign-up", "/sign-out", "/waiting"})
public class AuthController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("login"))
        {
            LoginPost(req, resp);
        } else if (url.contains("sign-up")) {
            SignUpPost(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath()+"/waiting").forward(req,resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("login")){
            LoginGet(req, resp);
        } else if (url.contains("sign-up")) {
            SignUpGet(req, resp);
        } else if (url.contains("sign-out")) {
            SignOutGet(req, resp);
        } else if (url.contains("waiting")){
            WaitingGet(req, resp);
        }
    }
    private void LoginPost(HttpServletRequest req, HttpServletResponse resp){
        try{
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");

            String alertMsg="";
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if(username.isEmpty() || password.isEmpty()){
                alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
                sendAlertMsg(req, resp, alertMsg);
                return;
            }

            boolean isRememberMe = false;
            String remember = req.getParameter("remember");
            if("on".equals(remember)){
                isRememberMe = true;
            }

            //main handle
            IUserService userService = new UserServiceImpl();
            Users user = userService.findByEmail(username);

            if(user == null){
                alertMsg = "Tài khoản không tồn tại";
                sendAlertMsg(req, resp, alertMsg);
                return;
            }
            if (!password.equals(user.getPasswd())){
                alertMsg = "Mật khẩu không đúng";
                sendAlertMsg(req, resp, alertMsg);
                return;
            }

            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            session.setAttribute("userId", (String.valueOf(user.getId())));
            session.setAttribute("account_name", user.getEmail());
            if(isRememberMe){
                saveRemeberMe(resp, username);
            }
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void LoginGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            //Kiểm tra trong session nếu có tài khoản thì chuyển trang
            HttpSession session = req.getSession(false);
            // Check cookie
            Cookie[] cookies = req.getCookies();
            if (session != null && session.getAttribute("account") != null) {
                resp.sendRedirect(req.getContextPath() + "/waiting");
                return;
            }
            else if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        session = req.getSession(true);
                        Users user = userService.findByEmail(cookie.getValue());
                        cookie.setMaxAge(5*60);
                        session.setAttribute("account", user);
                        session.setAttribute("userId", (String.valueOf(user.getId())));
                        resp.sendRedirect(req.getContextPath() + "/waiting");
                        return;
                    }
                }
            }
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void SignUpPost(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String passwd = req.getParameter("passwd");
            String re_pass = req.getParameter("re_pass");
            String email = req.getParameter("email");
            String readTerm = req.getParameter("agree-term");
            if (!passwd.equals(re_pass)){
                req.setAttribute("alert", "Mật khẩu nhập lại không trùng");
                req.getRequestDispatcher("views/register.jsp").forward(req, resp);
                return;
            }
            if (userService.findByEmail(email) != null){
                req.setAttribute("alert", "Tải khoản đã tồn tại");
                req.getRequestDispatcher("views/register.jsp").forward(req, resp);
                return;
            }
            if (!"on".equals(readTerm)){
                req.setAttribute("alert", "Vui lòng đồng ý điều khoản");
                req.getRequestDispatcher("views/register.jsp").forward(req, resp);
                return;
            }
            Users user = new Users();
            BeanUtils.populate(user, req.getParameterMap());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            user.setCreate_at(dtf.format(now));

            user.setRoles(0);
            String msg = "thành công";
            try{
                userService.createAccount(user);
            }catch (Exception e){
                msg = "thất bại";
            }
            req.setAttribute("announce", msg);
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void SignUpGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/register.jsp").forward(req, resp);
    }
    private void SignOutGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        Users u = (Users) session.getAttribute("account");
        try{
            req.getSession().invalidate();
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                    }
                }
            }
            if(u.getRoles() == 0){
                resp.sendRedirect(req.getContextPath() + "/user/home");
            }
            else if(u.getRoles() == 2) resp.sendRedirect(req.getContextPath() + "/login");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void WaitingGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account") != null) {
            Users u = (Users) session.getAttribute("account");
            req.setAttribute("email", u.getFullname());
            if (u.getRoles() == 1) {
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
            } else if (u.getRoles() == 2) {
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
            } else {
                resp.sendRedirect(req.getContextPath()+"/user/home");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }
    private void sendAlertMsg(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("alert", msg);
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
    private void saveRemeberMe(HttpServletResponse response, String username){
        Cookie cookie = new Cookie(Constants.COOKIE_REMEMBER, username);
        cookie.setMaxAge(15*60); //set for 15 min
        response.addCookie(cookie);
    }
}
