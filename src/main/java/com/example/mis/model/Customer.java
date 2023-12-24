package com.example.mis.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
@Data
@NoArgsConstructor


public class Customer {

    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id", scope = Product.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long customerId;
    private String customerName;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    // Constructor
    public Customer(String customerName, String address) {
        super();
        this.customerName = customerName;
        this.address = address;
    }

    //Getter
    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    //Setter
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {

        // Create a Product object with initial values
        Customer customer = new Customer("", "");

        // Use getter methods to retrieve product information
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Address: $" + customer.getAddress());

        // Use setter methods to update product information
        customer.setCustomerName("");
        customer.setAddress("");

        // Display updated product information
        System.out.println("\nUpdated Customer Information:");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Address: $" + customer.getAddress());
    }
}
