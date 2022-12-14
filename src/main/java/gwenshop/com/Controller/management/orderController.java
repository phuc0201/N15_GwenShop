package GwenShop.com.controller.management;
import GwenShop.com.Service.IOrderService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.OrderServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Order;
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
@WebServlet(urlPatterns = {"/order", "/order/load-table", "/order/create",
"/order/edit", "/order/delete"})
public class orderController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        if(url.contains("order/load-table"))
        {
            findAll(response, entityManager);
        }
        else if(url.contains("order/edit")){
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF-8");

        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("/views/admin/order.jsp");
            rq.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if(url.contains("create")){
            insert(request);
        }
    }
    public void insert(HttpServletRequest request){
        Order order = new Order();

        orderService.insert(order);
    }
    public String getStatusOrder(String stt){
        System.out.println(stt);
        if(Objects.equals(stt, "complete")){
            return "" +
                    "<div class=\"status_complete\">\n" +
                    "        <i class=\"fa-solid fa-check check\"></i>\n" +
                    "        Đã hoàn thành\n" +
                    "</div>";
        }
        else if(Objects.equals(stt, "untreated")){
            return "" +
                    "    <div class=\"status_untreated\">\n" +
                    "        <i class=\"fa-solid fa-circle-exclamation error\"></i>\n" +
                    "        Chưa xử lý\n" +
                    "    </div>";
        }
        else {
            return "" +
                    "<div class=\"status_processing\">\n" +
                    "        <i class=\"fa-solid fa-triangle-exclamation warning\"></i>\n" +
                    "        Đang xử lý\n" +
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
                "        <th>Khách hàng</th>\n" +
                "        <th>Địa chỉ</th>\n" +
                "        <th>Số điện thoại</th>\n" +
                "        <th>Trạng thái</th>\n" +
                "        <th>Người thực hiện</th>\n" +
                "        <th>Tổng tiền</th>\n" +
                "        <th>Ngày tạo</th>        \n" +
                "        <th></th>        \n" +
                "    </tr>\n" +
                "</thead><tbody>");
        List<Order> orders = orderService.findAll(entityManager);

        for(Order o: orders){
            String employee;
            try {
                employee = userService.findById(o.getEmployeeId(), entityManager).getFullname();
            }
            catch (Exception e){
                employee = "Chưa có người duyệt";
            }
            out.println("" +
                    "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td>"+o.getId()+"</td>\n" +
                    "<td>"+o.getFullName()+"</td>\n" +
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
                    "        <button class=\"btn_Edit\">\n" +
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
