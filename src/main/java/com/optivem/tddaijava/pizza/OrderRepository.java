package com.optivem.tddaijava.pizza;

public interface OrderRepository {
    void save(Order order);
    Order findById(int id);
}
