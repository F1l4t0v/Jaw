package com.example.jewelryworkshop.controller.web;

import com.example.jewelryworkshop.service.interfaces.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/sellings")
public class SellingUiController {
    @Autowired
    SellingService sellingService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("sellings", sellingService.getAll());
        return "sellings";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        sellingService.delete(id);
        return "redirect:/ui/v1/sellings/";
    }
}
