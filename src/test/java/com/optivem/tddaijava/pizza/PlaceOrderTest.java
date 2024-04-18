package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderTest {
    @Test
    void placeOrder() {
        // Arrange
        OrderRepository orderRepository = new InMemoryOrderRepository();
        PlaceOrder placeOrder = new PlaceOrder(orderRepository);
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;

        // Act
        Order order = placeOrder.execute(pizza, quantity);

        // Assert
        assertNotNull(order.getId());
        assertEquals(20.0, order.getPrice());
        assertEquals(order, orderRepository.findById(order.getId()));
    }
}