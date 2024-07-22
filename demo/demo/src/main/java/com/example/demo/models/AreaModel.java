package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "areas")
public class AreaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)

        private long id;

        @Column(nullable = false)
        private String nombreArea;

        private String ciudad;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getNombreArea() {
            return nombreArea;
        }
        public void setNombreArea(String nombreArea) {
            this.nombreArea = nombreArea;
        }
        public String getCiudad() {
            return ciudad;
        }
        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

    
}
