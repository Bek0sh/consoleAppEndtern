package controller;

import entitie.Product;
import repositories.interfaces.IProductRepository;

import java.util.Collections;
import java.util.List;

public class MarketController {
    private final IProductRepository repo;

    public MarketController(IProductRepository repo) {
        this.repo = repo;
    }

    public String createUser(String name, int price, String description, String type) {
        Product product = new Product(name, price, description, type);

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

    public String sortProductByPrice() {
        List<Product> products = repo.getAll();
        Collections.sort(products);
        Collections.reverse(products);
        return products.toString();
    }

    public String getProductsByType(String type) {
        List<Product> products = repo.getByType(type);
        return products.toString();
    }
}
