package com.example.jewelryworkshop.controller.web;

import com.example.jewelryworkshop.service.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/bills")
public class BillUiController {
    @Autowired
    BillService billService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("bills", billService.getAll());
        return "bills";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        billService.delete(id);
        return "redirect:/ui/v1/bills/";
    }
}
