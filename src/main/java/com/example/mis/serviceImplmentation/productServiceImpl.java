package com.example.mis.serviceImplmentation;
import com.example.mis.model.Product;
import com.example.mis.service.productService;
import com.example.mis.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class productServiceImpl implements productService{
    @Autowired
    private productRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
        }
    }



