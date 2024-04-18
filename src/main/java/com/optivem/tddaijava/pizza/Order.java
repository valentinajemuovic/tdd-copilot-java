package com.optivem.tddaijava.pizza;

public class Order {
    private static int nextId = 1;
    private int id;
    private Pizza pizza;
    private int quantity;
    private double price;

    public Order(Pizza pizza, int quantity, double price) {
        this.id = nextId++;
        this.pizza = pizza;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }
}