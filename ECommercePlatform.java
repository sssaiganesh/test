import EcommerceAPI.*;

class ECommercePlatform {
    public static void main(String[] args) {
        // Create some products
        ProductCatalog productCatalog = new ProductCatalog();
        Product shirt = new ClothingProduct(1, "Shirt", 19.99, "M");
        Product pants = new ClothingProduct(2, "Pants", 29.99, "L");
        Product phone = new ElectronicsProduct(3, "Phone", 599.99, "Apple");
        productCatalog.addProduct(shirt);
        productCatalog.addProduct(pants);
        productCatalog.addProduct(phone);

        // Print all products
        System.out.println("All products:");
        for (Product product : productCatalog.getAllProducts()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println();

        // Search for products by name
        System.out.println("Products with name 'Shirt':");
        for (Product product : productCatalog.getProductsByName("Shirt")) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println();

        // Search for clothing products by size
        System.out.println("Clothing products with size 'M':");
        for (ClothingProduct product : productCatalog.getClothingProductsBySize("M")) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice() + " - Size " + product.getSize());
        }
        System.out.println();

        // Create an order
        OrderManager orderManager = new OrderManager();
        Order order = new Order(1);
        order.addItem(shirt);
        order.addItem(phone);
        orderManager.placeOrder(order);

        // Get an order by ID
        System.out.println("EcommerceAPI.Order with ID 1:");
        Order retrievedOrder = orderManager.getOrderById(1);
        for (Product product : retrievedOrder.getItems()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total price: $" + retrievedOrder.getTotalPrice());
    }
}

// The driver code creates some products, adds them to a `EcommerceAPI.ProductCatalog`, and demonstrates how to search for products by name and clothing products by size.
// It then creates an order and places it using an `EcommerceAPI.OrderManager`, and demonstrates how to retrieve the order by ID.
// If any errors occur, such as attempting to add a duplicate product or retrieve an order that doesn't exist, the API will throw a custom exception with a meaningful error message.