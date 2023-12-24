package com.example.mis.model;
public class Product {
    private Long productId;
    private String productName;
    private double price;
    private int quantityInStock;

//Constructor
    public Product(String productName, double price, int quantityInStock) {
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
}

