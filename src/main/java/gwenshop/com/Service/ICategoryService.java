package GwenShop.com.Service;

import GwenShop.com.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public interface ICategoryService {
    void insert(String category_name);
    void update(Category category);
    void delete(int cateId) throws Exception;
    Category findById(int cateid);
    List<Category> findAll(EntityManager entityManager);
    List<Category> findByCategoryName(String catName);
}
