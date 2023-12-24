package com.example.mis.controller;
import com.example.mis.service.productService;
import com.example.mis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@Controller
public class productController {
@Autowired
productService productService;

    // new
    @RequestMapping(value = "/product/new", method = RequestMethod.GET)
    public String productRegForm(Model model){model.addAttribute("product", new Product());
        return "product/new";
    }

//    save

    @RequestMapping(value = "/product/new", method = RequestMethod.POST)
    public String registerNewProduct(Model model, Product product){
        product= productService.save(product);
        model.addAttribute("product", product);
        return "redirect:/product/list";
    }

//    list

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String findAllProduct(Model model){
        List<Product> Product= productService.findAll();
        model.addAttribute("product", Product);
        return "product/list";
    }


//Edit
   @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
   public String editProduct(Model model,@PathVariable Long id) {
     Product product = productService.findById(id);
     model.addAttribute("product", product);
     return "product/edit";
  }
    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public String editedProductData(Product product){
        productService.save(product);
        return "redirect:/product/list";
    }

}
