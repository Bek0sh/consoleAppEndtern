package entities;

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
    private String author;

    public Product(String name, int price, String description, String typeOfProduct, String author) {
        setName(name);
        setPrice(price);
        setDescription(description);
        setTypeOfProduct(typeOfProduct);
        setAuthor(author);
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
                "author = " + author +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.getPrice() > o.getPrice()){
            return 1;
        }else return -1;
    }


}
