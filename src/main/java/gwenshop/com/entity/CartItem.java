package GwenShop.com.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CartItem")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Tạo quan hệ bảng Many to one
    @ManyToOne
    @JoinColumn(name="CartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
