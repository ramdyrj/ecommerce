package com.example.velpay.controller;

import com.example.velpay.model.Orden;
import com.example.velpay.service.OrdenService;
import com.example.velpay.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orden")
public class OrdenController {


    @Autowired
    private OrdenService ordenService;

    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping("nuevaOrden")
    public String nuevaorden(Model model){
        model.addAttribute("title", "Nueva Orden");
        model.addAttribute("orden", new Orden());
        model.addAttribute("productos", productoService.findAll());
        return "productos/formOrden";
    }

    @PostMapping("ordenSave")
    public String ordenSave(Model model, Orden orden){
         ordenService.save(orden);
         return "redirect:/orden/listar";
    }

    @GetMapping("/listar")
    public String findAll(Model model){
        model.addAttribute("title", "Ordenes");
        model.addAttribute("ordenes", ordenService.findAll());
        return "productos/ordenes";
    }


}
