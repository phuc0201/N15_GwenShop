package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICategoryDAO;
import GwenShop.com.DAO.IProductDAO;
import GwenShop.com.Service.ICartItemService;
import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.ProductImage;
import GwenShop.com.util.JPAConfig;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public List<Product> findProductByName(String searchString) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.name like :name";
        TypedQuery<Product> query= enma.createQuery(jpql, Product.class);
        query.setParameter("name", "%" + searchString + "%");
        return query.getResultList();
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Product> query= enma.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }
    public List<Product> findAll(EntityManager entityManager) {
        TypedQuery<Product> query= entityManager.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT count(p.id) FROM Product p";
        Query query = enma.createQuery(jpql);

        return ((Long)query.getSingleResult()).intValue();
    }
    @Override
    public List<ProductImage> findProductImages(int id, EntityManager entityManager){
        String jpql = "SELECT p FROM ProductImage p where p.product.id = '"+id+"'";
        TypedQuery<ProductImage> query = entityManager.createQuery(jpql, ProductImage.class);
        return query.getResultList();
    }
    @Override
    public Product findProductById(int prodId, EntityManager enma) {
        Product product = enma.find(Product.class, prodId);
        return product;
    }
    @Override
    public void Insert(EntityManager entityManager, Product product, String[] images, String[] sizes, String[] colors)    {
        try {
            entityManager.getTransaction().begin();
            ProductImage productImage;
            IProductService productService = new ProductServiceImpl();
            entityManager.persist(product);
            Query newIdProd = entityManager.createQuery("select max(p.id) from Product p");
            int idProd = Integer.parseInt(newIdProd.getSingleResult().toString());
            for (String img: images){
                productImage = new ProductImage();
                productImage.setImage(img);
                productImage.setProduct(productService.findProductById(idProd, entityManager));
                entityManager.persist(productImage);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void delete(EntityManager entityManager, int idProd){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Product.class, idProd));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw e;
        }finally {
            entityManager.close();
        }
    }
    public void update(EntityManager entityManager, Product product, String[] ImageList){
        try {
            IProductService productService = new ProductServiceImpl();
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            List<ProductImage> productImages = productService.findProductImages(product.getId(), entityManager);
            boolean sameImg = false;
            for(ProductImage img: productImages){
                sameImg = false;
                for(int i = 0; i<ImageList.length; i++){
                    if(Objects.equals(img.getImage(), ImageList[i])){
                        ImageList[i] = "";
                        sameImg = true;
                    }
                }
                if(!sameImg){
                    entityManager.remove(img);
                }

            }
            ProductImage productImage;
            for(String img: ImageList){
                if(!Objects.equals(img, "")){
                    productImage = new ProductImage();
                    productImage.setImage(img);
                    productImage.setProduct(productService.findProductById(product.getId(), entityManager));
                    entityManager.persist(productImage);
                }

            }
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
