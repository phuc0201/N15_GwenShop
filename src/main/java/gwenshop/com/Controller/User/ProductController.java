package GwenShop.com.controller.User;

import GwenShop.com.Service.*;
import GwenShop.com.Service.Impl.*;
import GwenShop.com.entity.Cart;
import GwenShop.com.entity.CartItem;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
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

@WebServlet(urlPatterns = {"/product/addToCart", "/user/home", "/user/home/load-product",
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
        req.setAttribute("categoryList", categoryService.findAll(entityManager));
        if(url.contains("load-product")){
            findAll(resp, entityManager);
        }
        else if(url.contains("user/product")){
            Product product = productService.findProductById(Integer.parseInt(req.getParameter("id")), entityManager);
            List<ProductImage> productImages = productService.findProductImages(Integer.parseInt(req.getParameter("id")), entityManager);
            req.setAttribute("product", product);
            req.setAttribute("ImageList", productImages);
            req.getRequestDispatcher("/views/user/product_detail.jsp").forward(req,resp);
        }
        else if(url.contains("user/home")){
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
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<Product> products = productService.findAll(entityManager);
        for(Product p: products){
            out.println(" <div class=\"col-lg-4 col-md-6 col-sm-6\">\n" +
                    "              <div class=\"product__item\">\n" +
                    "                <div class=\"product__item__pic set-bg\" style=\"background-image: url('"+ productService.findProductImages(p.getId(), entityManager).get(0).getImage() +"');\">\n" +
                    "                   <ul class=\"product__item__pic__hover\">\n" +
                    "                        <li><a href=\"AddToCar?id="+p.getId()+"\" style = \" align-items: center; display: flex;\"><i class=\"fa fa-shopping-cart\" style=\"margin:auto;\"></i></a></li>" +
                    "                   </ul>"+
                    "                </div>\n" +
                    "                <div class=\"product__item__text\">\n" +
                    "                  <h6><a href=\"product?id="+p.getId()+"\">"+p.getName()+"</a></h6>\n" +
                    "                  <h5>"+p.getPrice()+"VND</h5>\n" +
                    "                </div>\n" +
                    "              </div>\n" +
                    "            </div>");
        }
    }
}
