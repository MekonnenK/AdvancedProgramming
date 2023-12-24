package com.example.mis.service;
import com.example.mis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface productService {
    @Autowired
    public abstract List<Product> findAll();
    public abstract Product findById(Long Id);
    public abstract Product save(Product product);
}
