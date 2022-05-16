package com.example.velpay.controller;

import com.example.velpay.model.Orden;
import com.example.velpay.service.OrdenService;
import com.example.velpay.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("ordenes", ordenService.findAll());
        return "productos/ordenes";
    }


    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        ordenService.delete(id);
        return "redirect:/orden/listar";
    }


    @GetMapping("/buscar")
    public String findByEmail(Model model, @Param(value = "status") String status) {
        model.addAttribute("titulo", "busquedas");
        model.addAttribute("estatus", status);
        model.addAttribute("ordenstatus", ordenService.findByStatus(status));
        return "busqueda";
    }

}
