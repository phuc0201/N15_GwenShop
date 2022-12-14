package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
@NoArgsConstructor
@Setter
@Getter
public class Orderdetail {
    @Id
    @Column(name = "order_id")
    private int id;
    @Column(name = "product_id")
    private int prod_id;
    @Column(name = "amount")
    private int amount;
}
