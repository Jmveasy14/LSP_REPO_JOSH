package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<String, Double> items;
    private double discountPercentage;

    public ShoppingCart() {
        items = new HashMap<>();
        discountPercentage = 0.0;
    }

    public void addItem(String itemName, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Item price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void removeItem(String itemName) {
        items.remove(itemName); // No exception if item doesn't exist
    }
}
