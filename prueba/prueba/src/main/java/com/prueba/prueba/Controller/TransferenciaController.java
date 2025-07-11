package com.prueba.prueba.Controller;

import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Service.TransferenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/prueba/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping("/tranferir")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferenciaDto transferencia) {
        try {
            transferenciaService.save(transferencia);
            return ResponseEntity.ok("Transación realizada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("error : " + e.getMessage());
        }
    }

}
