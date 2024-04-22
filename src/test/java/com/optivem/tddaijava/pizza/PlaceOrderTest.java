package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderTest {
    private OrderRepository orderRepository;
    private PlaceOrder placeOrder;
    private Pizza pizza;
    private int quantity;

    @BeforeEach
    void setUp() {
        orderRepository = new InMemoryOrderRepository();
        placeOrder = new PlaceOrder(orderRepository);
        pizza = new Pizza("Margherita", 10.0);
        quantity = 2;
    }

    @Test
    void testPlaceOrderWithValidPizzaAndQuantity() {
        Order order = placeOrder.execute(pizza, quantity);
        assertNotNull(order);
    }

    @Test
    void testPlaceOrderCalculatesCorrectPrice() {
        Order order = placeOrder.execute(pizza, quantity);
        assertEquals(20.0, order.getPrice());
    }

    @Test
    void testPlaceOrderAssignsUniqueId() {
        Order order1 = placeOrder.execute(pizza, quantity);
        Order order2 = placeOrder.execute(pizza, quantity);
        assertTrue(order2.getId() > order1.getId());
    }

    @Test
    void testPlaceOrderSavesOrderToRepository() {
        Order order = placeOrder.execute(pizza, quantity);
        assertEquals(order, orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderReturnsSavedOrder() {
        Order order = placeOrder.execute(pizza, quantity);
        assertEquals(order, orderRepository.findById(order.getId()));
    }
}