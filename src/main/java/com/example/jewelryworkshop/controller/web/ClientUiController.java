package com.example.jewelryworkshop.controller.web;

import com.example.jewelryworkshop.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/clients")
public class ClientUiController {
    @Autowired
    ClientService clientService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("clients", clientService.getAll());
        return "clients";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        clientService.delete(id);
        return "redirect:/ui/v1/clients/";
    }
}
