package com.prueba.prueba.Dto;

import java.util.Date;

public class ClientesDto {

    private String tp_identificacion;
    private String nombres;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private int numIdentificcion;

    //Getters
    public String getTp_identificacion() {
        return tp_identificacion;
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
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public int getNumIdentificcion() {
        return numIdentificcion;
    }

    //Setters
    public void setTp_identificacion(String tp_identificacion) {
        this.tp_identificacion = tp_identificacion;
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
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
