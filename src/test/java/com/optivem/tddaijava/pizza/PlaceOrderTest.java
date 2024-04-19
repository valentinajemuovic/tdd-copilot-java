package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderTest {
    @Test
    void placeOrderWithFirstOrder() {
        // Arrange
        OrderRepository orderRepository = new InMemoryOrderRepository();
        PlaceOrder placeOrder = new PlaceOrder(orderRepository);
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order1 = placeOrder.execute(pizza, quantity);

        // Assert
        assertNotNull(order1.getId());
        assertEquals(20.0, order1.getPrice());
        assertEquals(order1, orderRepository.findById(order1.getId()));
    }

    @Test
    void placeOrderWithSecondOrder() {
        // Arrange
        OrderRepository orderRepository = new InMemoryOrderRepository();
        PlaceOrder placeOrder = new PlaceOrder(orderRepository);
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order1 = placeOrder.execute(pizza, quantity);
        Order order2 = placeOrder.execute(pizza, quantity);

        // Assert
        assertNotNull(order2.getId());
        assertNotEquals(order1.getId(), order2.getId()); // This will fail if id is not properly incremented
        assertEquals(20.0, order2.getPrice());
        assertEquals(order2, orderRepository.findById(order2.getId()));
    }
}