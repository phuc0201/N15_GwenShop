package GwenShop.com.Service;

import GwenShop.com.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

public interface IOrderService {
    public Order findbyId (int id, EntityManager enma);
    public List<Order> findbyUserId (int id);
    public void insert (Order order);
    public void update (Order order);
    public void delete (int order) throws Exception;
    public List<Order> findAll(EntityManager entityManager);
}