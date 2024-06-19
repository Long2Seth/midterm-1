import Main.controller.ProductController;
import Main.model.Product;
import Main.service.ProductService;
import Main.service.serviceImpl.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        ProductController productController = new ProductController(productService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter operation number: \n1. Insert\n2. Read by ID\n3. Read all\n4. Delete");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                // Insert
                Product newProduct = new Product();
                System.out.println("Enter product ID:");
                newProduct.setId(scanner.nextInt());
                System.out.println("Enter product name:");
                newProduct.setName(scanner.next());
                System.out.println("Enter product price per unit:");
                newProduct.setPrice_per_unit(scanner.nextDouble());
                System.out.println("Enter product active for sale status (1 for active, 0 for not active):");
                newProduct.setActive_for_sale(scanner.nextInt());
                productController.createProduct(newProduct);
                break;
            case 2:
                // Read by ID
                System.out.println("Enter product ID to read:");
                int id = scanner.nextInt();
                Product readProduct = productService.readProduct(id);
                System.out.println("Read product: " + readProduct.getName());
                break;
            case 3:
                // Read all
                System.out.println( productController.readAllProducts());
                break;
            case 4:
                // Delete
                System.out.println("Enter product ID to delete:");
                int deleteId = scanner.nextInt();
                productController.deleteProduct(deleteId);
                break;
            default:
                System.out.println("Invalid operation number. Please enter a number between 1 and 4.");
                break;
        }

        scanner.close();
    }
}