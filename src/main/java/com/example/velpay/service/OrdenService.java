package com.example.velpay.service;

import com.example.velpay.model.Orden;
import com.example.velpay.repository.IRepositoryOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private IRepositoryOrden repositoryOrden;


    public List<Orden> findAll(){
        return  repositoryOrden.findAll();
    }

    public Orden save (Orden orden){
        return repositoryOrden.save(orden);
    }


    public void delete(int id){
        repositoryOrden.deleteById(id);
    }

}
