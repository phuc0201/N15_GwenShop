package GwenShop.com.Service;

import GwenShop.com.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUserService {
    public void createAccount(Users user);

    public void update(Users user);
    public void delete(int id);
    public Users findByEmail(String email);
    public List<Users> findUsersByName(String searchString);

    public Users findById(int userid, EntityManager enma);
    public List<Users> findAll(EntityManager entityManager, int role);
}
