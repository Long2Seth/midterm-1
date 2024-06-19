import Main.controller.ProductController;
import Main.model.Product;
import Main.service.ProductService;
import Main.service.serviceImpl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        ProductController productController = new ProductController(productService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter operation number: ");
            System.out.println("1. Insert");
            System.out.println("2. Read by ID");
            System.out.println("3. Read all");
            System.out.println("4. Delete");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Enter product ID:");
                    int id = scanner.nextInt();
                    System.out.println("Enter product name:");
                    String name = scanner.next();
                    System.out.println("Enter product price per unit:");
                    double pricePerUnit = scanner.nextDouble();
                    System.out.println("Enter product active for sale status (1 for active, 0 for not active):");
                    int activeForSale = scanner.nextInt();

                    Product newProduct = new Product();
                    newProduct.setId(id);
                    newProduct.setName(name);
                    newProduct.setPrice_per_unit(pricePerUnit);
                    newProduct.setActive_for_sale(activeForSale);
                    productController.createProduct(newProduct);
                    break;
                case 2:
                    System.out.println("Enter product ID:");
                    int readId = scanner.nextInt();
                    Product readProduct = productController.readProduct(readId);
                    if (readProduct != null) {
                        System.out.println("Read product: " + readProduct.getName());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    List<Product> products = productController.readAllProducts();
                    products.forEach(product ->
                            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName())
                    );
                    break;
                case 4:
                    System.out.println("Enter product ID to delete:");
                    int deleteId = scanner.nextInt();
                    productController.deleteProduct(deleteId);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }
    }
}
