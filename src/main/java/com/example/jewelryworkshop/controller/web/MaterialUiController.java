package com.example.jewelryworkshop.controller.web;

import com.example.jewelryworkshop.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/materials")
public class MaterialUiController {
    @Autowired
    MaterialService materialService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("materials", materialService.getAll());
        return "materials";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        materialService.delete(id);
        return "redirect:/ui/v1/materials/";
    }
}
