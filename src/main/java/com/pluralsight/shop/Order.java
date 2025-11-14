package com.pluralsight.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String orderID;
    private ArrayList<MenuItem> orderItems;
    private LocalDateTime orderTime;

    //starting number
    private static int startID = 1;

    // generates ID when order is created
    public Order() {
        this.orderID = String.format("%04d", ++startID);
        this.orderItems = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public String getOrderID() {
        return orderID;
    }

    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void addItem(MenuItem item) {
        orderItems.add(item);
    }

    public double getTotal() {
        return orderItems.stream()
                .mapToDouble(MenuItem::totalPrice)
                .sum();
    }
}