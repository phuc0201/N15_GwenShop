package GwenShop.com.controller.User;

import GwenShop.com.Service.*;
import GwenShop.com.Service.Impl.*;
import GwenShop.com.entity.*;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/user/product/addToCart", "/user/home",
"/user/product"})
public class ProductController extends HttpServlet{
    ICartService cartService = new CartServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IUserService userService = new UserServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        List<Product> products = productService.findAll(entityManager);
        req.setAttribute("categoryList", categoryService.findAll(entityManager));
        if(url.contains("user/product")){
            if(req.getParameter("id")!=null){
                int prodId = Integer.parseInt(req.getParameter("id"));
                Product product = productService.findProductById(prodId, entityManager);
                req.setAttribute("product", product);
                req.getRequestDispatcher("/views/user/product_detail.jsp").forward(req,resp);
            }else {
                List<Category> categories = categoryService.findAll(entityManager);
                req.setAttribute("products", products);
                req.setAttribute("category", categories);
                req.getRequestDispatcher("/views/user/product.jsp").forward(req,resp);
            }
        }
        else if(url.contains("user/home")){
            req.setAttribute("products", products);
            req.getRequestDispatcher("/views/user/home.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("addToCart")){
            addToCart(req, resp);
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            HttpSession session = req.getSession(true);
//            if(session.getAttribute("userId") == null){
//                resp.sendRedirect(req.getContextPath()+"/login");
//            }else {
//                int userId = Integer.parseInt((String) session.getAttribute("userId"));
//
//                int prodId = Integer.parseInt(req.getParameter("productId"));
//                //Kiểm tra user có cart hay chưa nếu chưa thì tạo
//                if (!cartService.existCart(userId)) {
//                    Cart cart = new Cart(userService.findById(userId));
//                    cartService.insert(cart);
//                }
//                Cart userCart = cartService.findCartByUserId(userId);
//                Product product = productService.findProductById(prodId);
//                //Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
//                if (!cartItemService.existCartItem(product)) {
//                    CartItem cartItem = new CartItem(userCart, product, 1);
//                    cartItemService.insert(userCart.addCartItem(cartItem));
//                }
//                else{
//                    CartItem cartItem = cartItemService.findByProdId(product);
//                    cartItem.setCount(cartItem.getCount() + 1);
//                    cartItemService.update(cartItem);
//                }
//            }
        }
//        catch  (Exception e) {
//            e.printStackTrace();
//            req.setAttribute("msg", "Eror: " + e.getMessage());
//        }
//    }
//    }
    private void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {

    }
}
