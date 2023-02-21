package controller;

import entitie.Product;
import repositories.interfaces.IProductRepository;
import java.util.List;

public class MarketController {
    private final IProductRepository repo;

    public MarketController(IProductRepository repo) {
        this.repo = repo;
    }

    public String createUser(String name, int price, String description) {
        Product product = new Product(name, price, description);

        boolean created = repo.create(product);

        return (created ? "Product was created!" : "Product creation was failed!");
    }

    public String getAllUsers() {
        List<Product> products = repo.getAll();

        return products.toString();
    }

    public String removeProduct(int id) {
        boolean removed = repo.removeProduct(id);
        return (removed ? "Product was removed" : "Something went wrong");
    }
}
