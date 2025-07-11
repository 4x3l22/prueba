package com.prueba.prueba.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "clientes")
public class Clientes extends BaseEntity {

    @Column(name = "tp_identificcion", length = 100, nullable = false)
    private String tpIdentificacion;

    @Column(name = "num_identificcion", length = 10, nullable = false)
    private int numIdentificcion;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, message = "El nombre debe tener por lo menos tres caracteres")
    @Column(name = "nombres", length = 500, nullable = false)
    private String nombres;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(min = 3, message = "El apellido debe tener por lo menos tres caracteres")
    @Column(name = "apellidos", length = 500, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    //Getters
    public String getTpIdentificacion() {
        return tpIdentificacion;
    }
    public int getNumIdentificcion() {
        return numIdentificcion;
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

    //Setters
    public void setTpIdentificacion(String tpIdentificacion) {
        this.tpIdentificacion = tpIdentificacion;
    }
    public void setNumIdentificcion(int numIdentificcion) {
        this.numIdentificcion = numIdentificcion;
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
