package repositories;

import data.IDB;
import entitie.Product;
import repositories.interfaces.IProductRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final IDB idb;

    public ProductRepository(IDB idb) {
        this.idb = idb;
    }

    @Override
    public boolean create(Product product) {
        Connection con = null;
        try {
            con = idb.getConnection();
            String sql = "INSERT INTO products(name,price,description) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, product.getName());
            st.setInt(2, product.getPrice());
            st.setString(3, product.getDescription());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        Connection con = null;
        try {
            con = idb.getConnection();
            String sql = "SELECT id, name, price, description FROM products";
            Statement st = con.createStatement();

            ResultSet rst = st.executeQuery(sql);
            List<Product> products = new LinkedList<>();

            while (rst.next()) {
                Product product = new Product(rst.getInt("id"),
                        rst.getString("name"),
                        rst.getInt( "price"),
                        rst.getString("description")
                        );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public boolean removeProduct(int id) {
        Connection con;
        try {
            con = idb.getConnection();
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement prst = con.prepareStatement(sql);

            prst.setInt(1, id);

            prst.execute();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
