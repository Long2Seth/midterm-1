package Main.controller;

import Main.model.Product;
import Main.service.ProductService;

public class ProductController {

    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void createProduct(Product product) {
        productService.createProduct(product);
    }

    public void readProduct( int id) {
        productService.readProduct( id);
    }

    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

    public void readAllProducts() {
        productService.readAllProducts();
    }


}
