package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICartItemDAO;
import GwenShop.com.entity.CartItem;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CartItemDAOImpl implements ICartItemDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public void insert(CartItem cartItem) {
        try {
            trans.begin();
            enma.persist(cartItem);
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
    public void update(CartItem cartItem) {
        try {
            trans.begin();
            enma.merge(cartItem);
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
    public void delete(int id) throws Exception {
        try {
            trans.begin();
            CartItem cartItem = enma.find(CartItem.class, id);
            if(cartItem != null) {
                enma.remove(cartItem);
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
    public CartItem findById(int id) {
        return null;
    }

    @Override
    public CartItem findByProdId(int productId) {
        return null;
    }
}
