package repositories.interfaces;

import entities.Product;

import java.util.List;

public interface IProductRepository {
    boolean create(Product product);
    List<Product> getAll();

    boolean removeProduct(int id);
    List<Product> getByType(String type);
}
