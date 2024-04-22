package com.optivem.tddaijava.pizza;

public class PlaceOrderRequest {
    private Pizza pizza;
    private int quantity;
    private String country;

    public PlaceOrderRequest(Pizza pizza, int quantity, String country) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.country = country;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCountry() {
        return country;
    }
}