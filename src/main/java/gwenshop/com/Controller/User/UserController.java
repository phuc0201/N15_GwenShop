package GwenShop.com.controller.User;


import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user", "/user/info", "/user/wishlist", "/user/changePasswd", "/user/update"})
public class UserController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
//    IWishListService wishListService = new WishListServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("changePasswd")){
            changePasswd(req, resp);
            return;
        } else if (url.contains("update")) {
            updateUser(req, resp);
            return;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("info")){
            UserGet(req, resp);
            return;
        } else if (url.contains("wishlist")) {
            wishListGet(req, resp);
            return;
        }
        req.getRequestDispatcher("/views/user/user_info.jsp").forward(req,resp);
    }

    private void UserGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            Users user_ = (Users) session.getAttribute("account");
            Users user = userService.findById(user_.getId());
            if (session != null && user != null){
                req.getRequestDispatcher("/views/user/user_info.jsp").forward(req,resp);
            }else{
                req.setAttribute("message", "Vui lòng đăng nhập để tiếp tục");
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void wishListGet(HttpServletRequest req, HttpServletResponse resp){
//        try{
//            HttpSession session = req.getSession();
//            Users user = (Users) session.getAttribute("account");
//            if (session != null && user != null){
//                //int userID = user.getId();
//                List<WishListItem> items = wishListService.findByUserID(user.getId());
//                req.setAttribute("items", items);
//                req.getRequestDispatcher("/views/user/TrangYeuThich/yeuthich.jsp").forward(req, resp);
//            }else{
//                req.setAttribute("message", "Vui lòng đăng nhập để tiếp tục");
//                resp.sendRedirect(req.getContextPath() + "/login");
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
    private void changePasswd(HttpServletRequest req, HttpServletResponse resp){
//        HttpSession session = req.getSession();
//        Users user = (Users) session.getAttribute("account");
//        try{
//
//            if(session != null && user != null){
//                HashPassword pw = new HashPassword();
//                String newPass = req.getParameter("Password");
//                String rePass = req.getParameter("ConfirmPassword");
//                String oldPass = pw.hash(req.getParameter("OldPassword"));
//                String result = "";
//                if (newPass.length()>=6) {
//                    if (newPass.equals(rePass)){
//                        result = userService.UpdatePasswd(user, oldPass, pw.hash(newPass));
//                        //Suppose to check in Service not here so plz ignore this
//                    }
//                    else
//                        result = "Mật khẩu nhập lại không trùng với mật khẩu mới";
//                }
//                else{
//                    result = "Mật khẩu quá ngắn vui lòng thử mật khẩu khác";
//                }
//
//                req.setAttribute("message", result);
//                System.out.println(result);
//                req.getRequestDispatcher("/views/user/TaiKhoan/doimk.jsp").forward(req, resp);
//            } else{
//                req.setAttribute("message", "vui lòng đăng nhập để tiếp tục");
//                resp.sendRedirect(req.getContextPath()+"/login");
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp){
//        HttpSession session = req.getSession();
//        Users user = (Users) session.getAttribute("account");
//        try{
//            if (session != null && user != null){
//                String addr = req.getParameter("addr");
//                String phoneNo = req.getParameter("phoneNumber");
//                String fullName = req.getParameter("fullName");
//
//                if ((!fullName.isEmpty() || !phoneNo.isEmpty())){
//                    fullName = fullName.isEmpty() ? user.getFullName() : fullName;
//                    addr = addr.isEmpty() ? user.getAddr() : addr;
//                    phoneNo = phoneNo.isEmpty() ? user.getPhoneNumber() : phoneNo;
//
//                    String mess = userService.update(user, addr, phoneNo, fullName);
//                    req.setAttribute("message", mess);
//                    System.out.println(mess);
//                }
//                else{
//                    req.setAttribute("message", "Vui lòng không để trống tên và số điện thoại");
//                }
//                req.getRequestDispatcher("/views/user/TaiKhoan/chitietND.jsp").forward(req, resp);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
