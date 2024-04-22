package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testGetId() {
        // Arrange
        OrderRepository orderRepository = new InMemoryOrderRepository();
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order = new Order(pizza, quantity, 20.0);
        order = orderRepository.save(order);

        // Assert
        assertNotNull(order.getId());
    }

    @Test
    void testIdIncrement() {
        // Arrange
        OrderRepository orderRepository = new InMemoryOrderRepository();
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order1 = new Order(pizza, quantity, 20.0);
        order1 = orderRepository.save(order1);
        Order order2 = new Order(pizza, quantity, 20.0);
        order2 = orderRepository.save(order2);

        // Assert
        assertTrue(order2.getId() > order1.getId());
    }
}