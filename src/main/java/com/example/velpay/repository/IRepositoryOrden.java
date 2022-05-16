package com.example.velpay.repository;

import com.example.velpay.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryOrden extends JpaRepository<Orden, Integer> {



}
