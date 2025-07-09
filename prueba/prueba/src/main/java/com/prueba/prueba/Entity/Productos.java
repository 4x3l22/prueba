package com.prueba.prueba.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Productos extends BaseEntity {

    @Column(name = "tip_cuenta",nullable = false,length = 2)
    private String tip_cuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @Column(name = "num_cuenta", nullable = false, length = 10)
    private int num_cuenta;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "saldo",nullable = false)
    private double saldo;

    @Column(name = "exenta_gmf", nullable = false)
    private String exenta_gmf;

    //Getters
    public String getTip_cuenta() {
        return tip_cuenta;
    }
    public Clientes getClientes() {
        return clientes;
    }
    public int getNum_cuenta() {
        return num_cuenta;
    }
    public String getEstado() {
        return estado;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getExenta_gmf() {
        return exenta_gmf;
    }

    //Setters
    public void tip_cuenta(String tip_cuenta) {
        this.tip_cuenta = tip_cuenta;
    }
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setExenta_gmf(String exenta_gmf) {
        this.exenta_gmf = exenta_gmf;
    }
}
