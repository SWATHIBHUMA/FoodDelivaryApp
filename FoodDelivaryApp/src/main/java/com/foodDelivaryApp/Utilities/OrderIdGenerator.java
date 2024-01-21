package com.foodDelivaryApp.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class OrderIdGenerator {

	public static int generateOrderId() {
        LocalDateTime orderDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedOrderDate = orderDate.format(formatter);

        int orderId = formattedOrderDate.hashCode();

        return Math.abs(orderId);
    }

    public static void main(String[] args) {
        int orderId = generateOrderId();
        System.out.println("Generated Order ID: " + orderId);
    }
}

