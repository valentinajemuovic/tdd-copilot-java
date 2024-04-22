package com.optivem.tddaijava.pizza;

public class PlaceOrder {
    private OrderRepository orderRepository;

    public PlaceOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order execute(Pizza pizza, int quantity, String country) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must order at least one pizza");
        }
        double price = pizza.getPrice() * quantity;
        price = applyDiscount(price, country);
        Order order = new Order(pizza, quantity, price);
        orderRepository.save(order);
        return order;
    }

    private double applyDiscount(double price, String country) {
        if ("US".equals(country)) {
            return price * 0.9; // Apply 10% discount
        }
        return price;
    }
}