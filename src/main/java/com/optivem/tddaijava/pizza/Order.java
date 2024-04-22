package com.optivem.tddaijava.pizza;

public class Order {
    private int id;
    private Pizza pizza;
    private int quantity;
    private double price;

    public Order(Pizza pizza, int quantity, double price) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }
}