package GwenShop.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Product_Detail")
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
