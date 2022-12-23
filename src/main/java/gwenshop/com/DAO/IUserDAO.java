package GwenShop.com.DAO;

import GwenShop.com.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUserDAO {
    public void createAccount(Users user);

    public void update(Users user);
    public void delete(int id);
    public Users findByEmail(String email);
    public List<Users> findUsersByName(String searchString);
    Users findById(int userid);

    List<Users> findAll(EntityManager entityManager, int role);
}
