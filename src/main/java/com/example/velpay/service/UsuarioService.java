package com.example.velpay.service;

import com.example.velpay.model.Usuario;
import com.example.velpay.repository.IRepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    public List<Usuario> findAll(){
        return  repositoryUsuario.findAll();
    }

    public Usuario save(Usuario usuario){
        return  repositoryUsuario.save(usuario);
    }



    public Optional<Usuario> Actualizar(int id){
        return repositoryUsuario.findById(id);
    }


    public void delete(int id){
         repositoryUsuario.deleteById(id);
    }


    public List<Usuario> finByUserName(String username){
        List<Usuario> usuarios =  repositoryUsuario.findByUsername(username);
        return  usuarios;
    }







}
