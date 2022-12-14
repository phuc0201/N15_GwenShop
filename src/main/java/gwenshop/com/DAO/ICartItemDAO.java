package GwenShop.com.DAO;

import GwenShop.com.entity.CartItem;

public interface ICartItemDAO {
    public void insert(CartItem cartItem);
    public void update(CartItem cartItem);
    public void delete(int id) throws Exception;
    public CartItem findById(int id);
    public CartItem findByProdId (int productId);
}
