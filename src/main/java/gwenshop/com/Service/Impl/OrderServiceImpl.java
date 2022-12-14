package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IOrderDAO;
import GwenShop.com.DAO.Impl.OrderDAOImpl;
import GwenShop.com.Service.IOrderService;
import GwenShop.com.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    IOrderDAO orderDao = new OrderDAOImpl();
    @Override
    public Order findbyId(int id,  EntityManager enma) {
        return orderDao.findbyId(id);
    }

    @Override
    public List<Order> findbyUserId(int id) {
        return orderDao.findbyUserId(id);
    }

    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void delete(int order) throws Exception {
        orderDao.delete(order);
    }
    public List<Order> findAll(EntityManager entityManager){
        return orderDao.findAll(entityManager);
    }
}
