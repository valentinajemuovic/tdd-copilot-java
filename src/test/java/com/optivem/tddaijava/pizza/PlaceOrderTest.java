package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

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
        assertThat(order).isNotNull();
    }

    @Test
    void testPlaceOrderCalculatesCorrectPrice() {
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order.getPrice()).isEqualTo(20.0);
    }

    @Test
    void testPlaceOrderAssignsUniqueId() {
        Order order1 = placeOrder.execute(pizza, quantity);
        Order order2 = placeOrder.execute(pizza, quantity);
        assertThat(order2.getId()).isGreaterThan(order1.getId());
    }

    @Test
    void testPlaceOrderSavesOrderToRepository() {
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderReturnsSavedOrder() {
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }
}