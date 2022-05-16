package com.example.velpay.service;

import com.example.velpay.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto save(Producto producto);
    public Optional<Producto> findById(int id);
    public void delete(int id);
}
