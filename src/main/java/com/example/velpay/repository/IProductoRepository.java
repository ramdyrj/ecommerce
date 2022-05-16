package com.example.velpay.repository;

import com.example.velpay.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Integer> {
}
