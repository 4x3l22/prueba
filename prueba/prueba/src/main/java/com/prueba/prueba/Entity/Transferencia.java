package com.prueba.prueba.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuentaOrigen", nullable = true)
    private Productos cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuentaDestino", nullable = true)
    private Productos cuentaDestino;

    @Column(name = "valorTransferencia", nullable = false)
    private Double valorTransferencia;

    @Column(name = "tipoTransferencia", nullable = false)
    private String tipoTransferencia;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    public Long getId() {
        return id;
    }
    public Productos getCuentaOrigen() {
        return cuentaOrigen;
    }
    public Productos getCuentaDestino() {
        return cuentaDestino;
    }
    public Double getValorTransferencia() {
        return valorTransferencia;
    }
    public String getTipoTransferencia() {
        return tipoTransferencia;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setCuentaOrigen(Productos cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
    public void setCuentaDestino(Productos cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
