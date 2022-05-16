package com.example.velpay.repository;

import com.example.velpay.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryOrden extends JpaRepository<Orden, Integer> {
}
