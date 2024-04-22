package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlaceOrderTest {
    private OrderRepository orderRepository;
    private PlaceOrder placeOrder;

    @BeforeEach
    void setUp() {
        orderRepository = new InMemoryOrderRepository();
        placeOrder = new PlaceOrder(orderRepository);
    }

    @Test
    void testPlaceOrderWithValidPizzaAndQuantity() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order).isNotNull();
    }

    @Test
    void testPlaceOrderCalculatesCorrectPrice() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order.getPrice()).isEqualTo(20.0);
    }

    @Test
    void testPlaceOrderAssignsUniqueId() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order1 = placeOrder.execute(pizza, quantity);
        Order order2 = placeOrder.execute(pizza, quantity);
        assertThat(order2.getId()).isGreaterThan(order1.getId());
    }

    @Test
    void testPlaceOrderSavesOrderToRepository() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderReturnsSavedOrder() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order = placeOrder.execute(pizza, quantity);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderWithNonPositiveQuantity() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 0;
        assertThrows(IllegalArgumentException.class, () -> placeOrder.execute(pizza, quantity), "You must order at least one pizza");
    }
}