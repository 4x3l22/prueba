package com.prueba.prueba.Controller;

import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.Service.ClientesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/prueba/Clientes")
public class ClientesController extends BaseController<Clientes>{

    public ClientesController(ClientesService clientesService) {
        super(clientesService);
    }


}
