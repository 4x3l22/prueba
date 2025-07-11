package com.prueba.prueba.Controller;

import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Service.TransferenciaService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/prueba/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }



}
