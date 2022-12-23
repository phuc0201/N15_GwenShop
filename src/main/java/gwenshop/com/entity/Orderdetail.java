package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
@NoArgsConstructor
@Setter
@Getter
public class Orderdetail {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
