package GwenShop.com.Service;

import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductService {
    public List<Product> findProductByName(String searchString);
    public List<Product> findAll(int page, int pageSize);
    Product findProductById(int prodId, EntityManager entityManager);
    public List<Product> findAll(EntityManager entityManager);
    public int count();
    public void delete(EntityManager entityManager, int idProd);
    public List<ProductImage> findProductImages(int id, EntityManager entityManager);
    public void Insert(EntityManager entityManager, Product product, String[] images, String[] sizes, String[] colors);
}
