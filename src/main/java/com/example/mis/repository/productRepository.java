package com.example.mis.repository;

import com.example.mis.model.Customer;
import com.example.mis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("productRepository")
public interface productRepository extends JpaRepository<Product,Long> {
}

