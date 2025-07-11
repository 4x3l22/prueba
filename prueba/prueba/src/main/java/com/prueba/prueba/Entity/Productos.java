package com.prueba.prueba.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Productos extends BaseEntity {

    @Column(name = "tip_cuenta", nullable = false, length = 100)
    private String tipCuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @Column(name = "num_cuenta", nullable = false, length = 10, unique = true)
    private long numCuenta;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "exenta_gmf", nullable = false)
    private String exentaGmf;

    //Getters
    public String getTipCuenta() {
        return tipCuenta;
    }
    public Clientes getClientes() {
        return clientes;
    }
    public long getNumCuenta() {
        return numCuenta;
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

    //Setters
    public void setTipCuenta(String tipCuenta) {
        this.tipCuenta = tipCuenta;
    }
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setExentaGmf(String exentaGmf) {
        this.exentaGmf = exentaGmf;
    }
}
