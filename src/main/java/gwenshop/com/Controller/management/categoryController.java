package GwenShop.com.controller.management;

import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Category;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/category", "/admin/category/load-table",
        "/admin/category/create",
        "/admin/category/delete",
        "/admin/category/edit"})
public class categoryController extends HttpServlet {
    ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager enma = JPAConfig.getEntityManager();
        if(url.contains("category/load-table"))
        {
            findAll(response, enma);
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("/views/admin/category.jsp");
            rq.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        if(url.contains("create")){
            insert(request, entityManager);
        } else if (url.contains("delete")) {
            try {
                delete(request, entityManager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(url.contains("edit")){
            update(request, entityManager);
        }
    }
    public void update(HttpServletRequest request, EntityManager entityManager){
        Category category = new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        categoryService.update(category);
    }
    public void insert(HttpServletRequest request, EntityManager entityManager){
        categoryService.insert(request.getParameter("name"));
    }
    public void delete(HttpServletRequest request, EntityManager entityManager) throws Exception {
        categoryService.delete(Integer.parseInt(request.getParameter("id")));
    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Category> categories = categoryService.findAll(entityManager);
        PrintWriter out = response.getWriter();
        out.println("<thead><tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Danh mục</th>\n" +
                "    <th>Tổng sản phẩm</th>\n" +
                "    <th></th>\n" +
                "</tr><thead><tbody>");
        for(Category c: categories){
            out.println("<tr>\n" +
                    "<td class=\"col__id-category\">"+c.getId()+"</td>\n" +
                    "<td class=\"col_name\">"+c.getName()+"</td>\n" +
                    "<td class=\"col__category-productAmount\">"+c.getProducts().size()+"</td> \n" +
                    "<td>\n" +
                    "   <button class=\"btn_Edit\">\n" +
                    "           <i class=\"fa-solid fa-pen-to-square\" style=\"color: white;\"></i>\n" +
                    "   </button>\n" +
                    "   <button class=\"btn_Delete\">\n" +
                    "         <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "    </button>\n" +
                    "</td>\n" +
                    "</tr>");
        }
        out.println("</tbody>");
    }
}
