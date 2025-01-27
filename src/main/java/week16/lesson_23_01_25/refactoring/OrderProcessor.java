package week16.lesson_23_01_25.refactoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderProcessor {
    private List<Order> orders = new LinkedList<>();

    public void processOrder(String customerId, List<String> itemIds, ShippingMethod shippingMethod) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            throw new OrderProcessException("Customer not found");
        }

        List<Item> items = getItemsListById(itemIds);

        if (items.isEmpty()) {
            throw new OrderProcessException("No valid items found for order");
        }

        double totalAmount = getTotalAmount(items);

        Double shippingCost = shippingMethod.getPrice();

        Order order = createOrder(customer, items, totalAmount, shippingCost);

        orders.add(order);
        System.out.println("Order processed: " + order.getId());
    }

    public void cancelOrder(long orderId) {
        Order orderToRemove = getOrderById(orderId);
        orders.remove(orderToRemove);
        System.out.println("Order canceled: " + orderToRemove.getId());

    }

    public void printOrderDetails(long orderId) {
        Order foundOrder = getOrderById(orderId);
        System.out.println("Order Details: ");
        System.out.println("Customer: " + foundOrder.getCustomer().getName());
        System.out.println("Items: ");
        for (Item item : foundOrder.getItems()) {
            System.out.println(" - " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total Amount: $" + foundOrder.getTotalAmount());
        System.out.println("Shipping Cost: $" + foundOrder.getShippingCost());
        System.out.println("Status: " + foundOrder.getStatus());
    }

    private Order getOrderById(long orderId) {
        return orders.stream()
                .filter(o -> o.getId() == orderId)
                .findAny()
                .orElseThrow(() -> new OrderProcessException("Order not found: " + orderId));
    }

    private static Order createOrder(Customer customer, List<Item> items, double totalAmount, Double shippingCost) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        order.setShippingCost(shippingCost);
        order.setStatus("Processing");
        return order;
    }

    private static double getTotalAmount(List<Item> items) {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    private Customer getCustomerById(String customerId) {
        // Simulated method to get customer by ID :
        return new Customer(customerId, "Customer Name");
    }

    private List<Item> getItemsListById(List<String> itemIds) {
        List<Item> items = new ArrayList<>();
        for (String itemId : itemIds) {
            Item item = getItemById(itemId);
            if (item != null) {
                items.add(item);
            } else {
                throw new OrderProcessException("Item not found: " + itemId);
            }
        }
        return items;
    }

    private Item getItemById(String itemId) {
        // Simulated method to get item by ID
        return new Item(itemId, "Item Name", Math.random() * 100);
    }
}

