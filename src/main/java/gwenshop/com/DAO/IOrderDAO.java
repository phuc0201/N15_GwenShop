package GwenShop.com.DAO;

import GwenShop.com.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

public interface IOrderDAO {
    public Order findbyId (int id);
    public List<Order> findbyUserId (int id);
    public void insert (Order order);
    public void update (Order order);
    public void delete (int order) throws Exception;
    public List<Order> findAll(EntityManager entityManager);
}
