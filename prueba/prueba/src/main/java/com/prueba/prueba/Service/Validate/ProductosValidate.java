package com.prueba.prueba.Service.Validate;

import com.prueba.prueba.Dto.ProductosDto;
import com.prueba.prueba.Repository.ProductosRepository;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProductosValidate {

    private final ProductosRepository productosRepository;

    public ProductosValidate(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }


    private boolean esCuentaValida(String cuenta) {
        if (cuenta == null) return false;
        return cuenta.equalsIgnoreCase("corriente") || cuenta.equalsIgnoreCase("ahorros");
    }

    private long numeroRandom(){

        Random rand = new Random();
        long min = 1000000000L;
        long max = 9999999999L;

        return min + ((long)(rand.nextDouble() * (max - min)));
    }

    public void validarProductoDto(ProductosDto dto) throws Exception {
        if (!esCuentaValida(dto.getTipCuenta())) {
            throw new Exception("La cuenta no es válida");
        }

        if (dto.getTipCuenta().equalsIgnoreCase("ahorros") && dto.getSaldo() <= 0) {
            throw new Exception("Las cuentas de tipo 'ahorros' deben tener un saldo mayor a 0");
        }
    }
}
