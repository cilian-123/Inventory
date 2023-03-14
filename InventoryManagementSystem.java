import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    private static final String MENU = "Please select an option:\n" +
            "1. Add product\n" +
            "2. Remove product\n" +
            "3. Update product quantity\n" +
            "4. View inventory\n" +
            "5. Exit\n" +
            "Choice: ";

    private static final ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(MENU);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    break;
                case 3:
                    updateProductQuantity(scanner);
                    break;
                case 4:
                    viewInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String productName = scanner.next();
        System.out.print("Enter product quantity: ");
        int productQuantity = scanner.nextInt();

        boolean productExists = false;
        for (Product product : inventory) {
            if (product.name.equals(productName)) {
                System.out.println("Product already exists. Updating quantity...");
                product.quantity += productQuantity;
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            inventory.add(new Product(productName, productQuantity));
            System.out.println("Product added successfully.");
        }
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String productName = scanner.next();

        boolean productRemoved = false;
        for (Product product : inventory) {
            if (product.name.equals(productName)) {
                inventory.remove(product);
                System.out.println("Product removed successfully.");
                productRemoved = true;
                break;
            }
        }

        if (!productRemoved) {
            System.out.println("Product not found.");
        }
    }

    private static void updateProductQuantity(Scanner scanner) {
        System.out.print("Enter product name: ");
        String productName = scanner.next();

        boolean productUpdated = false;
        for (Product product : inventory) {
            if (product.name.equals(productName)) {
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                product.quantity = newQuantity;
                System.out.println("Product quantity updated successfully.");
                productUpdated = true;
                break;
            }
        }

        if (!productUpdated) {
            System.out.println("Product not found.");
        }
    }

    private static void viewInventory() {
        System.out.println("Current inventory:");
        for (Product product : inventory) {
            System.out.println(product.name + ": " + product.quantity);
        }
    }
}
