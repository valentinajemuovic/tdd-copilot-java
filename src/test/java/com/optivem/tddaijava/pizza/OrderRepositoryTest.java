package com.optivem.tddaijava.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class OrderRepositoryTest {
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new InMemoryOrderRepository();
    }

    @Test
    void testSaveOrderReturnsSavedOrder() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        Order order = new Order(pizza, quantity, 20.0);
        Order savedOrder = orderRepository.save(order);
        assertThat(savedOrder).isEqualTo(order);
    }
}