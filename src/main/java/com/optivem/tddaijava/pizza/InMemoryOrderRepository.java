package com.optivem.tddaijava.pizza;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();
    private int nextId = 1;

    @Override
    public Order save(Order order) {
        order.setId(nextId++);
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Order findById(int id) {
        return orders.get(id);
    }
}