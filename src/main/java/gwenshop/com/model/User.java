package gwenshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int user_id;
    private String fullname;
    private String email;
    private String password;
    private String address;
    private String phonenumber;
    private float salary;
    private int role;

    public User(String fullname, String email, String password, String address, String phonenumber, float salary, int role){
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.role = role;
    };
}
