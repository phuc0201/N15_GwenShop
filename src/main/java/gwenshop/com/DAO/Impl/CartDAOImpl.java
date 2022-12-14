package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICartDAO;
import GwenShop.com.entity.Cart;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CartDAOImpl implements ICartDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public boolean existCart(int userId) {
        boolean isCart = enma.createQuery("FROM Cart C WHERE C.users.id = :userId")
                .setParameter("userId", userId)
                .getResultList()
                .size() > 0 ? true : false;
        return isCart;
    }

    @Override
    public List<Cart> findCartByUserId(int userId) {
        String jpql = "SELECT c FROM Cart c WHERE c.userId = :id";
        TypedQuery<Cart> query= enma.createQuery(jpql, Cart.class);
        query.setParameter("id", userId);
        return query.getResultList();
    }

    @Override
    public void insert(Cart cart) {
        try {
            trans.begin();
            enma.persist(cart);
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
    public void delete(int cartId) throws Exception {
        try {
            trans.begin();
            Cart cart = enma.find(Cart.class, cartId);
            if(cart != null) {
                enma.remove(cart);
            }else {
                throw new Exception("Không tìm thấy");
            }
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
    public void update(Cart cart) {
        try{
            trans.begin();
            enma.merge(cart);
            trans.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            trans.rollback();
            throw e;
        }
        finally {
            enma.close();
        }
    }
}
