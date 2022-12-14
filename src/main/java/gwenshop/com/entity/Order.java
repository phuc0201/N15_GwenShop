package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vw_order")
@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int userId;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "addr")
    private String address;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "statusOrder")
    private String status;
    @Column(name = "price")
    private int price;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "create_at")
    private String create_at;
}
