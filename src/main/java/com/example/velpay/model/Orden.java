package com.example.velpay.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double  total;
    private String status;

    @OneToOne
    private Producto producto;


   @ManyToOne
   private Usuario usuario;


    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Orden(int id, String numero, Date fechaCreacion, Date fechaRecibida, double total, String status, Usuario usuario, DetalleOrden detalle, Producto producto) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
        this.status = status;
        this.usuario = usuario;
        this.detalle = detalle;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DetalleOrden getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleOrden detalle) {
        this.detalle = detalle;
    }

    public Orden() {
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
