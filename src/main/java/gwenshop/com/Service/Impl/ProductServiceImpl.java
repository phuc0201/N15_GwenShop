package GwenShop.com.Service.Impl;


import GwenShop.com.DAO.IProductDAO;
import GwenShop.com.DAO.Impl.ProductDAOImpl;
import GwenShop.com.Service.IProductService;
import GwenShop.com.entity.Order;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.EntityManager;
import java.util.List;


public class ProductServiceImpl implements IProductService {
    IProductDAO productDao = new ProductDAOImpl();

    @Override
    public List<Product> findProductByName(String searchString) {
        return productDao.findProductByName(searchString);
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        return productDao.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return productDao.count();
    }

    @Override
    public Product findProductById(int prodId, EntityManager entityManager) {
        return productDao.findProductById(prodId, entityManager);
    }
    public void delete(EntityManager entityManager, int idProd){productDao.delete(entityManager, idProd);}
    public List<Product> findAll(EntityManager entityManager){ return productDao.findAll(entityManager);}
    public List<String> findProductImages(int id, EntityManager entityManager){return productDao.findProductImages(id, entityManager);}
    public void Insert(EntityManager entityManager, Product product, String[] images, String[] sizes, String[] colors){
        productDao.Insert(entityManager, product, images, sizes, colors);
    }
    public void update(Product product, String[] ImageList){
        productDao.update(product, ImageList);
    }
}
