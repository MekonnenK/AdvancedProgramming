package com.example.mis.service;
import com.example.mis.model.Customer;
import java.util.List;
public interface customerService {
    public abstract List<Customer> findAll();
    public abstract Customer findById(Long id);
    public abstract Customer save(Customer Customer);
}
