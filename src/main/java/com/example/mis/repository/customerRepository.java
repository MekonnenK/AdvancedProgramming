package com.example.mis.repository;
import com.example.mis.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("customerRepository")
public interface customerRepository extends JpaRepository<Customer,Long>{
}
