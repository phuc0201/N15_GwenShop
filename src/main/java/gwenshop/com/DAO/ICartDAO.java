package GwenShop.com.DAO;

import GwenShop.com.entity.Cart;

import java.util.List;

public interface ICartDAO {
    public boolean existCart (int userId);
    public List<Cart> findCartByUserId (int userId);
    public void insert (Cart cart);
    public void delete (int cartId)  throws Exception;
    public void update (Cart cart);
}
