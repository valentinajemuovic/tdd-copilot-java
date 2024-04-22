package com.optivem.tddaijava.pizza;

public class PlaceOrder {
    private OrderRepository orderRepository;

    public PlaceOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order execute(Pizza pizza, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("You must order at least one pizza");
        }
        double price = pizza.getPrice() * quantity;
        Order order = new Order(pizza, quantity, price);
        orderRepository.save(order);
        return order;
    }
}