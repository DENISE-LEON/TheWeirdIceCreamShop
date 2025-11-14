package com.pluralsight.shop;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private ArrayList<MenuItem> orderItems;
    //starts at 1
    private int startID = 1;

    //generated ID when order is created
    public Order(int orderID) {
        this.orderID  = String.format("%04d",startID++);
        this.orderItems = new ArrayList<>(orderItems);
    }

    public String getOrderID() {
        return orderID;
    }

    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
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
