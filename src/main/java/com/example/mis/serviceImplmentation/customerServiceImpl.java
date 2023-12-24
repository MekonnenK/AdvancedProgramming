package com.example.mis.serviceImplmentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mis.model.Customer;
import com.example.mis.repository.customerRepository;
import com.example.mis.service.customerService;
import java.util.List;
import java.util.Optional;
@Service
public class customerServiceImpl implements customerService {
    @Autowired
    private customerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    @Override
    public Customer findById(Long id) {
        Optional<Customer> optionalSupplier=customerRepository.findById(id);
        return optionalSupplier.orElse(null);
    }
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}

