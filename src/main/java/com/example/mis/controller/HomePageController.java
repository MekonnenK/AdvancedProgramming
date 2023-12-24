package com.example.mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomePageController {
    @GetMapping("/home")
    public String homeController(){ return "homepage/index";
    }
}
