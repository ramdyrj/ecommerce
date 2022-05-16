package com.example.velpay.controller;

import com.example.velpay.model.DetalleOrden;
import com.example.velpay.model.Orden;
import com.example.velpay.model.Producto;
import com.example.velpay.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    public List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    Orden orden = new Orden();

    @GetMapping("/lista")
    public String home(Model model){
        model.addAttribute("title","Productos");
        model.addAttribute("productos", productoService.findAll());
        return "productos/productos";
    }


    @GetMapping("nuevo")
    public String nuevo(Model model){
        model.addAttribute("title", "Producto Nuevo");
        model.addAttribute("producto", new Producto());
        return "/productos/formProducto";
    }


    @PostMapping("save")
    public String save(Model model, Producto producto){
        productoService.save(producto);
        return "redirect:/productos/lista";
    }

    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        productoService.delete(id);
        return "redirect:/productos/lista";
    }

    @GetMapping("/editar/{id}")
    public String update(@PathVariable("id") int id ,Model model){
        Optional<Producto> producto = productoService.findById(id);
        model.addAttribute("producto", producto);
        return "productos/formProducto";
    }






}
