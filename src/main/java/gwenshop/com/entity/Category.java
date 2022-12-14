package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vw_category")
@NamedQuery(name="Category.findAll", query = "SELECT c FROM Category c")
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "amount")
    private int amount;
//
//    //Tạo quan hệ
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
}
