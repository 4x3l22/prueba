package com.prueba.prueba.Controller;

import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.Service.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/prueba/productos")
public class ProductosController extends BaseController<Productos> {
    protected ProductosController(BaseService<Productos> baseService) {
        super(baseService);
    }
}
