package GwenShop.com.DAO;

import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductDAO {
    List<Product> findProductByName(String searchString);
    List<Product> findAll(int page, int pageSize);
    List<Product> findAll(EntityManager entityManager);
    int count();
    List<String> findProductImages(int id, EntityManager entityManager);
    Product findProductById(int prodId, EntityManager enma);
    public void delete(EntityManager entityManager, int idProd);
    void Insert(EntityManager entityManager, Product product, String[] images, String[] sizes, String[] colors);
    public void update(Product product, String[] ImageList);
}
