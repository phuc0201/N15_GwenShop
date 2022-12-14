package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICategoryDAO;
import GwenShop.com.entity.Category;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public void insert(String category_name) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("insert into category(category_name) value (?)").setParameter(1, category_name).executeUpdate();
            entityManager.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            enma.getTransaction().begin();
            enma.createNativeQuery("update category set category_name=? where id=?")
                            .setParameter(1, category.getName()).setParameter(2, category.getId())
                            .executeUpdate();
            enma.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            enma.getTransaction().rollback();
        }finally {
            enma.close();
        }
    }

    @Override
    public void delete(int cateId) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            enma.getTransaction().begin();
            enma.createNativeQuery("delete from category where id=?").setParameter(1, cateId).executeUpdate();
            enma.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            enma.getTransaction().rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public Category findById(int cateid) {
        EntityManager entityManager = JPAConfig.getEntityManager();
        return entityManager.find(Category.class, cateid);
    }
    @Override
    public List<Category> findAll(EntityManager entityManager){
        String jpql = "SELECT c FROM Category c";
        TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        ICategoryDAO categoryDAO = new CategoryDAOImpl();
//        EntityManager enma = JPAConfig.getEntityManager();
//        try {
//            enma.getTransaction().begin();
//            enma.createNativeQuery("delete from category where id=8").executeUpdate();
//            enma.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            enma.close();
//        }
//    }
}
