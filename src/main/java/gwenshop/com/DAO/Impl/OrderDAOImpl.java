package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IOrderDAO;
import GwenShop.com.entity.Order;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public Order findbyId(int id) {
        Order order = enma.find(Order.class, id);
        return order;
    }

    @Override
    public List<Order> findbyUserId(int id) {
        String jpql = "SELECT o FROM Order o WHERE o.userId = :id";
        TypedQuery<Order> query= enma.createQuery(jpql, Order.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void insert(Order order) {
        try {
            trans.begin();
            enma.persist(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void update(Order order) {
        try {
            trans.begin();
            enma.merge(order);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void delete(int order) throws Exception {
       EntityManager entityManager = JPAConfig.getEntityManager();
       try{
           entityManager.getTransaction().begin();
           entityManager.createNativeQuery("delete from orders where id=?")
                           .setParameter(1, order)
                                   .executeUpdate();
           entityManager.getTransaction().commit();
       }catch (Exception e){
           e.printStackTrace();
           entityManager.getTransaction().rollback();
       }
    }
    public List<Order> findAll(EntityManager entityManager){
        String jpql = "SELECT o FROM Order o";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        return query.getResultList();
    }
}
