package repositories.interfaces;

import entitie.Product;

import java.util.List;

public interface IProductRepository {
    boolean create(Product product);
    List<Product> getAll();

    boolean removeProduct(int id);
}
