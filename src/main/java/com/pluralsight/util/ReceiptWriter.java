package com.pluralsight.util;

import com.pluralsight.shop.MenuItem;
import com.pluralsight.shop.Order;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public void recieptWriter(Order order) {

        String folderPath = "src/main/resources/reciepts";

        //  Create file path inside folder
        //time formatter for the reciept name
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

        String orderTIme = order.getOrderTime().format(formatter2);

        //file path with folder and name
        String filePath = folderPath + "/receipt_" + orderTIme + ".txt" ;

        //Format the order date/time using the timestamp inside Order
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        String dateTime = order.getOrderTime().format(formatter);


        //true checks if file exists and appends to the file
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {

            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println("              THE WEIRD ICE CREAM SHOP");
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println("Order ID: " + order.getOrderID());
            writer.println("Date: " + dateTime);
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println();
            writer.println("Items Ordered:");
            writer.println("--------------------------------------------");

            for (MenuItem item : order.getOrderItems()) {
                writer.println("- " + item.getName() + "     $" +
                        String.format("%.2f", item.totalPrice()));
            }

            writer.println("--------------------------------------------");
            writer.println();
            writer.println("Total: $" + String.format("%.2f", order.getTotal()));
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println();
            writer.println("       THANK YOU FOR STOPPING BY");
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        } catch (Exception e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
