package com.example.jewelryworkshop.controller.web;

import com.example.jewelryworkshop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/products")
public class ProductUiController {
    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/ui/v1/products/";
    }
}
