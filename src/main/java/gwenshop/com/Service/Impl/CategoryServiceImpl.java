package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.ICategoryDAO;
import GwenShop.com.DAO.Impl.CategoryDAOImpl;
import GwenShop.com.Service.ICategoryService;
import GwenShop.com.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDAO cateDAO = new CategoryDAOImpl();
    @Override
    public void insert(String category_name) {
        cateDAO.insert(category_name);
    }

    @Override
    public void update(Category category) {
        cateDAO.update(category);
    }

    @Override
    public void delete(int cateid) throws Exception {
        cateDAO.delete(cateid);
    }

    @Override
    public Category findById(int cateid) {
        return cateDAO.findById(cateid);
    }

    @Override
    public List<Category> findAll(EntityManager entityManager) {
        return cateDAO.findAll(entityManager);
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        return findByCategoryName(catName);
    }
}
