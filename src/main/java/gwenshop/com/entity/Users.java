package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "addr")
    private String addr;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "roles")
    private int roles;

    @Column(name = "create_at")
    private String create_at;

    //Tạo quan hệ
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    //    public Users(int id, String fullName, String email, String passwd, String addr, String phoneNumber, int salary, int roles, Date create_at) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.passwd = passwd;
//        this.addr = addr;
//        this.phoneNumber = phoneNumber;
//        this.salary = salary;
//        this.roles = roles;
//        this.create_at = create_at;
//    }
//
//    public Users(int id, String fullName, String email, String passwd, String addr, String phoneNumber, int roles, Date create_at) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.passwd = passwd;
//        this.addr = addr;
//        this.phoneNumber = phoneNumber;
//        this.roles = roles;
//        this.salary = 0;
//        this.create_at = create_at;
//    }
//    public Users(){};
}
