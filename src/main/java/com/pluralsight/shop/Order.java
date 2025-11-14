package com.pluralsight.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String orderID;
    private ArrayList<MenuItem> orderItems;
    //starts at 1
    private int startID = 1;
    private LocalDateTime orderTime;

    //generated ID when order is created
    public Order() {
        this.orderID  = String.format("%04d",startID++);
        this.orderItems = new ArrayList<>(orderItems);
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
                .mapToDouble(i -> i.totalPrice())
                .sum();
    }

}
