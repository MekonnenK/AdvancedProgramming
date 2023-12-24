package com.example.mis.controller;
import com.example.mis.model.Customer;
import com.example.mis.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class customerController {
    @Autowired
    customerService customerService;

    // new
    @RequestMapping(value = "/customer/new", method = RequestMethod.GET)
    public String customerRegForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

//    save

    @RequestMapping(value = "/customer/new", method = RequestMethod.POST)
    public String registerNewProduct(Model model, Customer customer) {
        customer = customerService.save(customer);
        model.addAttribute("customer", customer);
        return "redirect:/customer/list";
    }

//    list

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public String findAllCustomer(Model model) {
        List<Customer> customer = customerService.findAll();
        model.addAttribute("customer", customer);
        return "customer/list";
    }
    //Edit

    @RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.GET)
    public String editSupplier(Model model,@PathVariable Long id){
        Customer customer= customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @RequestMapping(value = "/customer/edit", method = RequestMethod.POST)
    public String editedProductData(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }
}
