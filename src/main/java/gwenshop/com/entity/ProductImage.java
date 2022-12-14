package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product_Image")
@Getter
@Setter
@NoArgsConstructor
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "prod_image")
    private String image;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //Constructor
}
