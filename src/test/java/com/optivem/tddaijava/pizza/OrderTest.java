package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testIdIncrement() {
        // Arrange
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order1 = new Order(pizza, quantity, 10.0);
        Order order2 = new Order(pizza, quantity, 10.0);

        // Assert
        assertTrue(order2.getId() > order1.getId()); // This will fail if id is not properly incremented
    }

    @Test
    void testGetId() {
        // Arrange
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order = new Order(pizza, quantity, 10.0);

        // Assert
        assertNotEquals(0, order.getId()); // This will fail if getId() returns 0
    }
}