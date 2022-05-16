package com.example.velpay.service;

import com.example.velpay.model.Producto;
import com.example.velpay.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public void delete(int id) {
            productoRepository.deleteById(id);
    }
}
