package GwenShop.com.controller.management;

import GwenShop.com.Service.IOrderService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.Impl.OrderServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.entity.Order;
import GwenShop.com.entity.Orderdetail;
import GwenShop.com.entity.Product;
import GwenShop.com.util.JPAConfig;
import org.hibernate.validator.constraints.Range;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/dashboard"})
public class dashboardController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Product> products = productService.findAll(entityManager);
        List<Order> orders = orderService.findAll(entityManager);
        req.setAttribute("total_product", products.size());
        req.setAttribute("total_order", orders.size());

        for(int p = 0; p < products.size(); p++){
            for(int i=p+1; i< products.size(); i++){
                if(products.get(p).getOrderItems().size() < products.get(i).getOrderItems().size()){
                    Collections.swap(products, p, i);
                }
            }
        }
        if(products.size() > 5) {
            req.setAttribute("top_products", products.subList(0, 5));
        }else req.setAttribute("top_products", products);

        int total_priceOrder = 0;
        for (Order o: orders){
            total_priceOrder+= o.getPrice();
        }
        req.setAttribute("revenue", total_priceOrder);
        req.getRequestDispatcher("/views/admin/dashboard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
