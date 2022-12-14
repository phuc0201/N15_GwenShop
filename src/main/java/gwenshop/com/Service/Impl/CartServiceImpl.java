package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.ICartDAO;
import GwenShop.com.DAO.Impl.CartDAOImpl;
import GwenShop.com.Service.ICartService;
import GwenShop.com.entity.Cart;

import java.util.List;

public class CartServiceImpl implements ICartService {
    ICartDAO cartDao = new CartDAOImpl();
    @Override
    public boolean existCart(int userId) {
        return cartDao.existCart(userId);
    }

    @Override
    public List<Cart> findCartByUserId(int userId) {
        return cartDao.findCartByUserId(userId);
    }

    @Override
    public void insert(Cart cart) {
        cartDao.insert(cart);
    }

    @Override
    public void delete(int cartId) throws Exception {
        cartDao.delete(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
