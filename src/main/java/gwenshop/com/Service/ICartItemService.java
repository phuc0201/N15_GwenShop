package GwenShop.com.Service;

import GwenShop.com.entity.CartItem;

public interface ICartItemService {
    public void insert(CartItem cartItem);
    public void update(CartItem cartItem);
    public void delete(int id) throws Exception;
    public CartItem findById(int id);
    public CartItem findByProdId (int productId);
}
