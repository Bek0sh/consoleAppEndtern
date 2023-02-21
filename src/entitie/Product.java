package entitie;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private String description;

    public Product(String name, int price,String description) {
        setName(name);
        setPrice(price);
        setDescription(description);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product {" + "\n" +
                "id = " + id + ", \n" +
                "name = " + name + ", \n" +
                "price = " + price + "$" + ", \n" +
                "description = " + description + "\n" +
                '}';
    }
}
