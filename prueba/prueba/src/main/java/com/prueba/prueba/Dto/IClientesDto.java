package com.prueba.prueba.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public interface IClientesDto {

    @NotBlank
    @NotNull(message = "Campo nulo")
    @NotEmpty
    @Email
    String getTp_identificacion();
    String getNombres();
    String getApellidos();
    String getEmail();
    Date getFecha_nacimiento();
    int getNum_identificcion();
}
