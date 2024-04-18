package com.optivem.tddaijava.pizza;

import java.util.Map;
import java.util.HashMap;

public class InMemoryOrderRepository implements OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public Order findById(int id) {
        return orders.get(id);
    }
}
