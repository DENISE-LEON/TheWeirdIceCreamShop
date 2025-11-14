package com.pluralsight.util;

import com.pluralsight.shop.Order;
import java.io.*;
import java.time.format.DateTimeFormatter;
import com.pluralsight.shop.*;

public class ReceiptWriter {

    public void recieptWriter(Order order) {
        //formatting for reciept file
        String filePath = "receipt_" + order.getOrderID() + ".txt";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        String formattedTime = order.getOrderTime().format(formatter);


        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))) {

            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println("              THE WEIRD ICE CREAM SHOP");
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println("Order ID: " + String.format("%04d", order.getOrderID()));
            writer.println("Date: " + formattedTime);
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println();
            writer.println("Items Ordered:");
            writer.println("--------------------------------------------");


            order.getOrderItems.println("- " + item.getName() + "     $" +
                            String.format("%.2f", item.totalPrice()));

            writer.println("--------------------------------------------");
            writer.println();
            writer.println("Total: $" + String.format("%.2f", order.getTotal()));
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            writer.println();
            writer.println("       THANK YOU FOR STOPPING BY");
            writer.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error writing receipt");
        }
    }
}
