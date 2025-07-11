package com.prueba.prueba.Controller;

import com.prueba.prueba.Dto.ProductosDto;
import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.Service.BaseService;
import com.prueba.prueba.Service.ProductosService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/prueba/productos")
public class ProductosController extends BaseController<Productos> {
    private final ProductosService productosService;

    protected ProductosController(BaseService<Productos> baseService, ProductosService productosService) {
        super(baseService);
        this.productosService = productosService;
    }

    @Override
    @Hidden
    public ResponseEntity<Productos> save(@RequestBody Productos entity) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Operación no permitida para productos");
    }

    @Override
    @Hidden
    public ResponseEntity<Productos> update(@PathVariable Long id, @RequestBody Productos entity) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Operacion no permitida para productos");
    }


    @PostMapping("/registroproduct")
    public ResponseEntity<String> registroProducto(@Valid @RequestBody ProductosDto productosDto) {
        try {
            productosService.saveProductos(productosDto);
            return ResponseEntity.ok("Registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/actualizarproduct/{id}")
    public ResponseEntity<String> actualizarProducto(@Valid @PathVariable long id, @RequestBody ProductosDto productosDto) {
        try {
            productosService.updateProductos(id, productosDto);
            return ResponseEntity.ok("Actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(@RequestBody TransferenciaDto dto) {
        try {
            productosService.transferir(dto);
            return ResponseEntity.ok("Transferencia realizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }


}
