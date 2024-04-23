package com.optivem.tddaijava.pizza;

public class PlaceOrderRequestBuilder {
    private Pizza pizza;
    private int quantity;
    private String country;

    public PlaceOrderRequestBuilder() {
        this.pizza = new Pizza("Margherita", 10.0);
        this.quantity = 1;
        this.country = "UK";
    }

    public PlaceOrderRequestBuilder withPizza(Pizza pizza) {
        this.pizza = pizza;
        return this;
    }

    public PlaceOrderRequestBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PlaceOrderRequestBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public PlaceOrderRequest build() {
        return new PlaceOrderRequest(pizza, quantity, country);
    }
}