package com.optivem.tddaijava.pizza;

public interface OrderRepository {
    Order save(Order order);
    Order findById(int id);
}