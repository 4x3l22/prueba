package com.prueba.prueba.Dto;

import java.time.LocalDateTime;

public class ProductosDto {

    private String tipCuenta;
    private Long idCliente;
    private String estado;
    private double saldo;
    private String exentaGmf;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    //Getters
    public String getTipCuenta() {
        return tipCuenta;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public String getEstado() {
        return estado;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getExentaGmf() {
        return exentaGmf;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

}
