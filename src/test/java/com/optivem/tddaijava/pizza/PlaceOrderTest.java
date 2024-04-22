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
    void testPlaceOrderWithValidPizzaAndQuantity() {
        // Test implementation goes here
    }

    @Test
    void testPlaceOrderCalculatesCorrectPrice() {
        // Test implementation goes here
    }

    @Test
    void testPlaceOrderAssignsUniqueId() {
        // Test implementation goes here
    }

    @Test
    void testPlaceOrderSavesOrderToRepository() {
        // Test implementation goes here
    }

    @Test
    void testPlaceOrderReturnsSavedOrder() {
        // Test implementation goes here
    }
}