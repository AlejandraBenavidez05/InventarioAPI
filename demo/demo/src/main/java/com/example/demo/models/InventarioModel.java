package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "activos")
public class InventarioModel {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String tipo;
    private String fechaCompra;
    private int serial;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaCompra() {
        return this.fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getSerial() {
        return this.serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    
}
