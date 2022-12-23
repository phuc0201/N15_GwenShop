package GwenShop.com.controller.management;

import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/employee", "/admin/employee/create", "/admin/employee/delete", "/admin/employee/edit",
"/admin/employee/load-table", "/admin/customer", "/admin/customer/load-table",
"/admin/employee/deleteMany", "/admin/customer/deleteMany"})
public class userController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        if (url.contains("employee/load-table")){
            findAll(response, entityManager, 1);
        }
        else if (url.contains("customer/load-table")){
            findAll(response, entityManager, 0);
        }
        else {
            request.getRequestDispatcher("/views/admin/user.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("create")){
            insert(request,response);
        }
        else if(url.contains("edit")){
            update(request,response);
        }
        else if(url.contains("employee/deleteMany")){
            deleteMany(request, response);
        }
        else if(url.contains("delete")){
            delete(request, response);
        }
        else {
            request.getRequestDispatcher("/views/admin/user.jsp").forward(request,response);
        }
    }
    private void findAll(HttpServletResponse resp,EntityManager entityManager, int role) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        List<Users> userList = userService.findAll(entityManager, role);
        resp.setCharacterEncoding("UTF-8");
        String datatable = "";
        for(Users u: userList){
            datatable = datatable + "<tr>" +
                    "<td><input type=\"checkbox\"></td>" +
                    "<td>"+u.getId()+"</td>" +
                    "<td class=\"col_name\">"+u.getFullname()+"</td>" +
                    "<td>"+u.getEmail()+"</td>" +
                    "<td>"+u.getPasswd()+"</td>" +
                    "<td>"+u.getAddr()+"</td>" +
                    "<td>"+u.getPhonenumber()+"</td>" +
                    "<td>"+u.getCreate_at()+"</td>" +
                    "</tr>";
        }
        PrintWriter out = resp.getWriter();
        out.println(
                "<thead>\n" +
                        "   <tr>\n" +
                        "       <th></th>\n" +
                        "       <th>ID</th>\n" +
                        "       <th>Họ và tên</th>\n" +
                        "       <th>Email</th>\n" +
                        "       <th>Mật khẩu</th>\n" +
                        "       <th>Địa chỉ</th>\n" +
                        "       <th>Số điện thoại</th>\n" +
                        "       <th>Ngày tạo</th>\n" +
                        "   </tr>\n" +
                        "</thead>\n" +
                        "  <tbody>" +
                        datatable +
                        "</tbody>"
        );
    }
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String url = req.getRequestURL().toString();
        Users user = new Users();
        req.setCharacterEncoding("UTF-8");
        try {
            BeanUtils.populate(user, req.getParameterMap());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            user.setCreate_at(dtf.format(now));
            if(url.contains("employee")){
                user.setRoles(1);
            }
            IUserService userService = new UserServiceImpl();
            PrintWriter out = resp.getWriter();
            if(userService.findByEmail(req.getParameter("email")) == null)
            {
                userService.createAccount(user);
                out.print("success");
            }else out.print("error");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String url = req.getRequestURL().toString();
        PrintWriter out = resp.getWriter();
        try {
            Users user = new Users();
            req.setCharacterEncoding("UTF-8");
            BeanUtils.populate(user, req.getParameterMap());
            if(url.contains("employee")){
                user.setRoles(1);
            }
            IUserService userService = new UserServiceImpl();
            Users finduser = userService.findByEmail(req.getParameter("email"));
            if(finduser == null || finduser.getId() == user.getId())
            {
                userService.update(user);
            }else out.print("error");
        }
        catch (Exception e){
            out.print("error");
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try
        {
            IUserService userService = new UserServiceImpl();
            userService.delete(Integer.parseInt(req.getParameter("id")));
        }catch (Exception e){
            out.print("error");
            e.printStackTrace();
        }
    }
    private void deleteMany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String[] listId = request.getParameterValues("arrayData[]");
        for(String id: listId){
            try
            {
                IUserService userService = new UserServiceImpl();
                userService.delete(Integer.parseInt(id));
            }catch (Exception e){
                out.print("error");
                e.printStackTrace();
            }
        }
    }
}
