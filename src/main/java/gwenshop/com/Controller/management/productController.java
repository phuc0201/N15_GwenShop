package GwenShop.com.controller.management;
import GwenShop.com.DAO.Impl.ProductDAOImpl;
import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/product", "/product/load-table", "/product/create", "/product/delete", "/product/edit"})
public class productController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        request.setAttribute("categoryList", categoryService.findAll(entityManager));
        if(url.contains("product/load-table")){
            findAll(response, entityManager);
        }
        else if(url.contains("product/edit")){
            PrintWriter out = response.getWriter();
            ProductImage productImage = new ProductImage();
            List<ProductImage> productImages = productService.findProductImages(Integer.parseInt(request.getParameter("id")),entityManager);
            for (ProductImage p: productImages){
                out.println("<div class=\"image-item_wrapper\">"+
                        "<div class=\"image-item\" style=\"background-image: url('"+p.getImage()+"');\">n"+
                        " </div>" +
                        "<i class=\"fa-solid fa-circle-minus icon-minus\"></i>\n"+
                        " </div>");
            }
        }
        else {
            request.getRequestDispatcher("/views/admin/product.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();

        if(url.contains("create")){
            insert(request, entityManager);
        }
        else if(url.contains("delete")){
            delete(request, entityManager);
        }
        else if(url.contains("product/edit")){
            update(request, entityManager);
        }
        else if(url.contains("product/load-table")){
            findAll(response, entityManager);
        }
        else {
            request.getRequestDispatcher("/views/admin/product.jsp").forward(request,response);
        }
    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        response.setCharacterEncoding("UTF-8");
        IProductService productService = new ProductServiceImpl();
        List<Product> products = productService.findAll(entityManager);
        String header_table = "<thead>"+"<tr>\n" +
                "    <th></th>\n" +
                "    <th>ID</th>\n" +
                "    <th>ID Danh mục</th>\n" +
                "    <th>Ảnh</th>\n" +
                "    <th>Tên sản phẩm</th>\n" +
                "    <th>Mô tả</th>\n" +
                "    <th>Số lượng</th>\n" +
                "    <th>Giá</th>\n" +
                "    <th></th>\n" +
                "</tr>" + "</thead>";
        String data_table = "";
        PrintWriter out = response.getWriter();
        out.println(header_table + "<tbody>");
        for(Product p: products){
            data_table = "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td class=\"col__id-product\">"+p.getId()+"</td>\n" +
                    "<td class=\"col__id-category\">"+p.getCategory().getId()+"</td>\n" +
                    "<td class=\"col__product-image\">\n" +
                    "    <div class=\"product-image\" style=\"background-image: url('"+ productService.findProductImages(p.getId(), entityManager).get(0).getImage() +"');\">\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "<td class=\"col__product-name\">"+p.getName()+"</td>\n" +
                    "<td class=\"col__product-description\">\n" +
                    "    <textarea readonly class=\"product-description\">"+p.getDescription()+"</textarea>\n" +
                    "</td>\n" +
                    "<td class=\"col__amount\">"+p.getAmount()+"</td>\n" +
                    "<td class=\"col__price\">"+p.getPrice()+"</td>\n" +
                    "<td>\n" +
                    "    <div class=\"\" style=\"display: flex; align-items: center;\">\n" +
                    "        <button class=\"btn_Edit\">\n" +
                    "            <i class=\"fa-solid fa-pen-to-square\" style=\"color: white;\"></i>\n" +
                    "        </button>\n" +
                    "        <button class=\"btn_Delete\" name=\"delete\">" +
                    "            <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "</tr>";
            out.println(data_table);
        }
        out.println("</tbody>");
    }
    public void insert(HttpServletRequest request, EntityManager entityManager){
        Product product = new Product();
        String[] ImageList= request.getParameterValues("arrayData[]");
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setAmount(Integer.parseInt(request.getParameter("amount")));
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        productService.Insert(entityManager, product, ImageList, null, null);
    }
    public void delete(HttpServletRequest request, EntityManager entityManager){
        productService.delete(entityManager, Integer.parseInt(request.getParameter("id")));
    }
    public void update(HttpServletRequest request, EntityManager entityManager){
        Product product = new Product();
        String[] ImageList= request.getParameterValues("arrayData[]");
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setAmount(Integer.parseInt(request.getParameter("amount")));
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO .update(entityManager, product, ImageList);
    }
}
