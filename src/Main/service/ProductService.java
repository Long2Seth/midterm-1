package Main.service;

import Main.model.Product;

import java.util.List;

public interface ProductService {

    // Create product
    public void createProduct(Product product);


    Product readProduct(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> readAllProducts();
}
