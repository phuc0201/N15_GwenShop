package gwenshop.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int product_id;
    private int category_id;
    private String prod_name;
    private String description;
    private String image;
    private int amount;
    private String hot_product;
    private float price;
}
