package Main.controller;

import Main.model.Product;
import Main.service.ProductService;

import java.util.List;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void createProduct(Product product) {
        productService.createProduct(product);
    }

    public Product readProduct(int id) {
        return productService.readProduct(id);
    }

    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

    public List<Product> readAllProducts() {
        return productService.readAllProducts();
    }
}
