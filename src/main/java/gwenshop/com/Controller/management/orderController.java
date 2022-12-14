package GwenShop.com.controller.management;
import GwenShop.com.Service.IOrderService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.OrderServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Order;
import GwenShop.com.entity.Orderdetail;
import GwenShop.com.entity.Product;
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
import java.util.Objects;
@WebServlet(urlPatterns = {"/admin/order", "/admin/order/load-table", "/admin/order/create",
"/admin/order/edit", "/admin/order/delete"})
public class orderController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        if(url.contains("order/load-table"))
        {
            findAll(response, entityManager);
        }
        else if(url.contains("order/edit")){
            List<Orderdetail> orderdetails = orderService.findProducts(Integer.parseInt(request.getParameter("id")));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            for(Orderdetail order: orderdetails){
                Product product = productService.findProductById(order.getProduct().getId(),entityManager);
                out.println("<div class=\"row\">\n" +
                        "                        <div class=\"image\" style = \"background-image: url('"+product.getProductImages().get(0).getImage()+"');\"></div>\n" +
                        "                        <div class=\"Info\">\n" +
                        "                           <div class=\"\">\n" +
                        "                                <span>"+product.getCategory().getName()+"</span>\n" +
                        "                                <span>"+product.getName()+"</span>\n" +
                        "                           </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"amount\">\n" +
                        "                            <span>"+order.getAmount()+"</span>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"price\">\n" +
                        "                            <span>"+product.getPrice()+"vn??</span>\n" +
                        "                        </div>\n" +
                        "                    </div>");
            }
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("/views/admin/order.jsp");
            rq.forward(request,response);
        }
        entityManager.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if(url.contains("delete")){
            try {
                orderService.delete(Integer.parseInt(request.getParameter("id")));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getStatusOrder(String stt){
        System.out.println(stt);
        if(Objects.equals(stt, "complete")){
            return "" +
                    "<div class=\"status_complete\">\n" +
                    "        <i class=\"fa-solid fa-check check\"></i>\n" +
                    "        ???? ho??n th??nh\n" +
                    "</div>";
        }
        else if(Objects.equals(stt, "untreated")){
            return "" +
                    "    <div class=\"status_untreated\">\n" +
                    "        <i class=\"fa-solid fa-circle-exclamation error\"></i>\n" +
                    "        Ch??a x??? l??\n" +
                    "    </div>";
        }
        else {
            return "" +
                    "<div class=\"status_processing\">\n" +
                    "        <i class=\"fa-solid fa-triangle-exclamation warning\"></i>\n" +
                    "        ??ang x??? l??\n" +
                    "</div>";
        }
    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("" +
                "<thead>\n" +
                "    <tr>\n" +
                "        <th></th>\n" +
                "        <th>ID</th>\n" +
                "        <th>Kh??ch h??ng</th>\n" +
                "        <th>?????a ch???</th>\n" +
                "        <th>S??? ??i???n tho???i</th>\n" +
                "        <th>Tr???ng th??i</th>\n" +
                "        <th>Ng?????i th???c hi???n</th>\n" +
                "        <th>T???ng ti???n</th>\n" +
                "        <th>Ng??y t???o</th>        \n" +
                "        <th></th>        \n" +
                "    </tr>\n" +
                "</thead><tbody>");
        List<Order> orders = orderService.findAll(entityManager);

        for(Order o: orders){
            String employee;
            try {
                employee = userService.findById(o.getEmployeeId()).getFullname();
            }
            catch (Exception e){
                employee = "Ch??a c?? ng?????i duy???t";
            }
            out.println("" +
                    "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td>"+o.getId()+"</td>\n" +
                    "<td class=\"col_name\">"+o.getFullName()+"</td>\n" +
                    "<td>"+o.getAddress()+"</td>\n" +
                    "<td>"+o.getPhoneNumber()+"</td>\n" +
                    "<td class=\"\" name = \"status\">\n" +
                    getStatusOrder(o.getStatus()) +
                    "</td>\n" +
                    "<td>"+
                    employee +
                    "</td>\n" +
                    "<td>"+o.getPrice()+"</td>\n" +
                    "<td>"+o.getCreate_at()+"</td>\n" +
                    "<td>\n" +
                    "    <div class=\"\" style=\"display: flex; align-items: center;\">\n" +
                    "        <button class=\"btn_ShowInfo_Order\">\n" +
                    "            <i class=\"fa-solid fa-file-invoice-dollar\" style=\"color: white;\"></i>\n" +
                    "        </button>\n" +
                    "        <button class=\"btn_Delete\">\n" +
                    "            <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "</tr>");
        }
        out.println("</tbody>");
    }
}
