package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table (name = "asignaciones")
public class AsignacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "activo_id", nullable = false)
    private InventarioModel activo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaModel area;

    private String persona;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InventarioModel getActivo() {
        return activo;
    }

    public void setActivo(InventarioModel activo) {
        this.activo = activo;
    }

    public AreaModel getArea() {
        return area;
    }

    public void setArea(AreaModel area) {
        this.area = area;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

}
