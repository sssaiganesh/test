package EcommerceAPI;

import EcommerceAPI.DuplicateOrderException;
import EcommerceAPI.Order;
import EcommerceAPI.OrderNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders;

    public OrderManager() {
        this.orders = new HashMap<>();
    }

    public void placeOrder(Order order) {
        if (orders.containsKey(order.getId())) {
            throw new DuplicateOrderException("EcommerceAPI.Order with ID " + order.getId() + " already exists");
        }
        orders.put(order.getId(), order);
    }

    public Order getOrderById(int orderId) {
        if (!orders.containsKey(orderId)) {
            throw new OrderNotFoundException("EcommerceAPI.Order with ID " + orderId + " not found");
        }
        return orders.get(orderId);
    }
}
