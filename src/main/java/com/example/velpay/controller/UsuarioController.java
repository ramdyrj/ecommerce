package com.example.velpay.controller;

import com.example.velpay.model.Usuario;
import com.example.velpay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/app")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/")
    public String home(Model model){
        return "index";
    }


    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("title", "Usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());
        return "allUsuarios";
    }


    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("title", "nuevo usuario".toUpperCase());
        model.addAttribute("usuario", new Usuario());
        return "/formUsuario";
    }


    @PostMapping("/save")
    public String save(Model model, Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/app/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Usuario> usuario = usuarioService.Actualizar(id);
        model.addAttribute("usuario",usuario);
        return "/formUsuario";
    }


    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id, Model model){
        usuarioService.delete(id);
        return  "redirect:/app/usuarios";
    }

    @GetMapping("/ordenes")
    public String findByUserName(Model model, @Param( value = "username") String username){
        model.addAttribute("user", usuarioService.finByUserName(username));
        return "Ordenes";
    }








}
