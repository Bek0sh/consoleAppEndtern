package entitie;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private int price;
    private String description;
    private String typeOfProduct;

    public Product(String name, int price, String description, String typeOfProduct) {
        setName(name);
        setPrice(price);
        setDescription(description);
        setTypeOfProduct(typeOfProduct);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setTypeOfProduct(String type) {
        this.typeOfProduct = type;
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

    @Override
    public int compareTo(Product o) {
        if (this.getPrice() > o.getPrice()){
            return 1;
        }else return -1;
    }


}
