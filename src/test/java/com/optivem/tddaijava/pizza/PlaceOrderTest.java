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
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        Order order = placeOrder.execute(request);
        assertThat(order).isNotNull();
    }

    @Test
    void testPlaceOrderCalculatesCorrectPrice() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        Order order = placeOrder.execute(request);
        assertThat(order.getPrice()).isEqualTo(20.0);
    }

    @Test
    void testPlaceOrderAssignsUniqueId() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        Order order1 = placeOrder.execute(request);
        Order order2 = placeOrder.execute(request);
        assertThat(order2.getId()).isGreaterThan(order1.getId());
    }

    @Test
    void testPlaceOrderSavesOrderToRepository() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        Order order = placeOrder.execute(request);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderReturnsSavedOrder() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        Order order = placeOrder.execute(request);
        assertThat(order).isEqualTo(orderRepository.findById(order.getId()));
    }

    @Test
    void testPlaceOrderWithNonPositiveQuantity() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 0;
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry("UK")
                .build();
        assertThrows(IllegalArgumentException.class, () -> placeOrder.execute(request), "You must order at least one pizza");
    }

    @Test
    void testPlaceOrderAppliesDiscountForUS() {
        Pizza pizza = new Pizza("Margherita", 10.0);
        int quantity = 2;
        String country = "US";
        PlaceOrderRequest request = new PlaceOrderRequestBuilder()
                .withPizza(pizza)
                .withQuantity(quantity)
                .withCountry(country)
                .build();
        Order order = placeOrder.execute(request);
        assertThat(order.getPrice()).isEqualTo(18.0); // 10% discount applied
    }
}