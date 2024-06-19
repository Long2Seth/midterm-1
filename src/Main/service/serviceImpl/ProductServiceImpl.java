package Main.service.serviceImpl;

import Main.model.Product;
import Main.service.ProductService;
import Main.util.DbSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private Connection connection;

    public ProductServiceImpl() {
        this.connection = DbSingleton.instance();
    }

    @Override
    public void createProduct(Product product) {
        String sql = "INSERT INTO products (id, name, price_per_unit, active_for_sale) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice_per_unit());
            pstmt.setInt(4, product.getActive_for_sale());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating product", e);
        }
    }

    @Override
    public Product readProduct(int id) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice_per_unit(rs.getDouble("price_per_unit"));
                product.setActive_for_sale(rs.getInt("active_for_sale"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading product", e);
        }

        return product;
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, price_per_unit = ?, active_for_sale = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice_per_unit());
            pstmt.setInt(3, product.getActive_for_sale());
            pstmt.setInt(4, product.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product", e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product", e);
        }
    }

    @Override
    public List<Product> readAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice_per_unit(rs.getDouble("price_per_unit"));
                product.setActive_for_sale(rs.getInt("active_for_sale"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading all products", e);
        }

        return products;
    }

}