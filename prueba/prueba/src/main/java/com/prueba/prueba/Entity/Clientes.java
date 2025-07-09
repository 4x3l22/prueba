package com.prueba.prueba.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "clientes")
public class Clientes extends BaseEntity{

    @Column(name = "tp_identificcion", length = 100, nullable = false)
    private String tp_identificacion;

    @Column(name = "num_identificcion", length = 10, nullable = false)
    private int num_identificcion;

    @Column(name = "nombres", length = 500, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 500, nullable = false)
    private String apellidos;

    @Column(name = "email",length = 100, nullable = false)
    private String email;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;

    //Getters
    public String getTp_identificacion() {
        return tp_identificacion;
    }
    public int getNum_identificcion() {
        return num_identificcion;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getEmail() {
        return email;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    //Setters
    public void setTp_identificacion(String tp_identificacion) {
        this.tp_identificacion = tp_identificacion;
    }
    public void setNum_identificcion(int num_identificcion) {
        this.num_identificcion = num_identificcion;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
