package EcommerceAPI;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> items;
    private double totalPrice;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public int getId() {
        return id;
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItem(Product product) {
        items.add(product);
        totalPrice += product.getPrice();
    }
}
