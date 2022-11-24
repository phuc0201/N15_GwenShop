package gwenshop.com.Controller;

import gwenshop.com.util.Path.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Im at register do get");
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }
        req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String re_password = req.getParameter("re_pass");
        String email = req.getParameter("email");

        String phone = req.getParameter("phone");
        //iUserService service = new UserServices();
        String alertMsg = "";
        if (password.isEmpty() | email.isEmpty() | fullname.isEmpty() | phone.isEmpty()){
            alertMsg = "Không được để trống các mục";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        if (!password.equals(re_password)){
            alertMsg = "Mật khẩu nhập lại không trùng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
//        if (service.checkExistEmail(email)) {
//            alertMsg = "Email đã tồn tại!";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
//            return;
//        }
//        if (service.checkExistUsername(username)) {
//            alertMsg = "Tài khoản đã tồn tại!";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
//            return;
//        }
//        boolean isSuccess = service.register(username, password, email, fullname, phone);
        if (true) {
            alertMsg = "Đăng ký thành công";
            req.setAttribute("announce", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        }
    }
}
