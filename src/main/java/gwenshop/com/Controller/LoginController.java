package gwenshop.com.Controller;

import gwenshop.com.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Kiểm tra trong session nếu có tài khoản thì chuyển trang
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }

        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean isRememberMe = false;
            String remember = req.getParameter("remember");
            if("on".equals(remember)){
                isRememberMe = true;
            }
            //Check if there is does not have input
            String alertMsg="";
            if(username.isEmpty() || password.isEmpty()){
                alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                return;
            }

            //main handle
            //iUserService service = new UserServices();
            //User user = service.login(username, password);
            if(username.equals("toan") && password.equals("123456")){
                HttpSession session = req.getSession(true);
                session.setAttribute("account", "toan");
                session.setAttribute("account_name", "toandungpq");
                if(isRememberMe){
                    saveRemeberMe(resp, username);
                }
                resp.sendRedirect(req.getContextPath()+"/waiting");
            }else{
                alertMsg = "Tài khoản hoặc mật khẩu không đúng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    private void saveRemeberMe(HttpServletResponse response, String username){
        Cookie cookie = new Cookie(Constants.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
