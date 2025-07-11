package com.prueba.prueba.Dto;

import java.time.LocalDateTime;

public class TransferenciaDto {

    private long cuentaOrigen;
    private long cuentaDestino;
    private double valor;
    private String tipoTransferencia;
    private LocalDateTime fechaCreacion;

    //Gettters
    public long getCuentaOrigen() {
        return cuentaOrigen;
    }
    public long getCuentaDestino() {
        return cuentaDestino;
    }
    public double getValor() {
        return valor;
    }
    public String getTipoTransferencia() {
        return tipoTransferencia;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
