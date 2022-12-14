package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.ICartItemDAO;
import GwenShop.com.DAO.Impl.CartItemDAOImpl;
import GwenShop.com.Service.ICartItemService;
import GwenShop.com.entity.CartItem;

public class CartItemServiceImpl implements ICartItemService {
    ICartItemDAO cartItemDao = new CartItemDAOImpl();

    @Override
    public void insert(CartItem cartItem) {
        cartItemDao.insert(cartItem);
    }

    @Override
    public void update(CartItem cartItem) {
        cartItemDao.update(cartItem);
    }

    @Override
    public void delete(int id) throws Exception {
        cartItemDao.delete(id);
    }

    @Override
    public CartItem findById(int id) {
        return cartItemDao.findById(id);
    }

    @Override
    public CartItem findByProdId(int productId) {
        return cartItemDao.findByProdId(productId);
    }
}
