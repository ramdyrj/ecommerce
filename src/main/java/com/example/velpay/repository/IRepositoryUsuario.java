package com.example.velpay.repository;

import com.example.velpay.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryUsuario extends JpaRepository<Usuario, Integer> {

     List<Usuario> findByUsername(String username);
}
