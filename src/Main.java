import Main.controller.ProductController;
import Main.model.Product;
import Main.service.ProductService;
import Main.service.serviceImpl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {


        ProductService productService = new ProductServiceImpl();
        ProductController productController = new ProductController(productService);

        // Create a new product
        Product newProduct = new Product();
        newProduct.setId(1);
        newProduct.setName("Product 1");
        newProduct.setPrice_per_unit(10.0);
        newProduct.setActive_for_sale(1);
        productController.createProduct(newProduct);

        // Read a product
        Product readProduct = productService.readProduct(1);
        System.out.println("Read product: " + readProduct.getName());

        // Update a product
        newProduct.setName("Updated Product 1");
        productController.updateProduct(newProduct);

        // Delete a product
        productController.deleteProduct(1);


    }
}