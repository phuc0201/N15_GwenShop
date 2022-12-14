package GwenShop.com.DAO.Impl;
import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;
import javax.persistence.*;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private static Object object;
    @Override
    public void createAccount(Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            enma.getTransaction().begin();
            enma.persist(user);
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
    public void update(Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            enma.getTransaction().begin();
            enma.merge(user);
            enma.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            enma.getTransaction().rollback();
            throw e;
        }finally {
            enma.close();
        }
    }
    public void delete(int id){
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            enma.getTransaction().begin();
            enma.remove(enma.find(Users.class, id));
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
    public Users findByEmail(String email) {
        EntityManager enma = JPAConfig.getEntityManager();
        Users user = enma.find(Users.class, email);
        return user;
    }
//    public Users findAccount(String email, String PassWord){
//
//    }
    @Override
    public List<Users> findUsersByName(String searchString) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT u FROM Users u WHERE u.fullname like :name";
        TypedQuery<Users> query= enma.createQuery(jpql, Users.class);
        query.setParameter("name", "%" + searchString + "%");
        return query.getResultList();
    }

    @Override
    public Users findById(int userid, EntityManager enma) {
        Users user = enma.find(Users.class, userid);
        return user;
    }
    @Override
    public List<Users> findAll(EntityManager entityManager, int role) {
        String jpql = "SELECT u FROM Users u where u.roles = '"+role+"'";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        return query.getResultList();
    }

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
//        Users users = userDAO.findAccount("hoangphuc01022002@gmail.com", "phuc02012002");
        EntityManager entityManager = JPAConfig.getEntityManager();
    }
}
