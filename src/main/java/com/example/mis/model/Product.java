package com.example.mis.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
    public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private double price;
    private int quantityInStock;
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@Id", scope = Customer.class)
    private Customer customer;

    //Constructor
    public Product(String productName, double price, int quantityInStock) {
        super();
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getter
    public String getProductName() {

        return productName;
    }

    public double getPrice() {
        return price;
    }


    public int getQuantityInStock() {

        return quantityInStock;
    }

    //Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;

    }
    public static void main(String[] args) {

        // Create a Product object with initial values

        Product product = new Product("Cargo Body", 999.99, 5);

        // Use getter methods to retrieve product information
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Quantity: " + product.getQuantityInStock());

        // Use setter methods to update product information
        product.setProductName("Cargo Body");
        product.setPrice(1099.99);
        product.setQuantityInStock(8);

        // Display updated product information
        System.out.println("\nUpdated Product Information:");
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Quantity: " + product.getQuantityInStock());
    }
    }



