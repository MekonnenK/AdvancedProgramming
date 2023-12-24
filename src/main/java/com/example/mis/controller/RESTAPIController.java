package com.example.mis.controller;
import com.example.mis.model.Product;
import com.example.mis.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")

public class RESTAPIController {
    @Autowired

    productService productService;

    @GetMapping(value = "/product/{id}")
    @ResponseBody
//get mapping
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    //post mapping
    @PostMapping(value = "/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }


}