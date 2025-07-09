package com.prueba.prueba.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_modificacion",nullable = false)
    private LocalDateTime fecha_modificacion;

    @Column(name = "fecha_eliminacion",nullable = true)
    private LocalDateTime fecha_eliminacion;

    //Getters
    public Long getId() {
        return id;
    }
    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }
    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }
    public LocalDateTime getFecha_eliminacion() {
        return fecha_eliminacion;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    public void setFecha_eliminacion(LocalDateTime fecha_eliminacion) {
        this.fecha_eliminacion = fecha_eliminacion;
    }
}
