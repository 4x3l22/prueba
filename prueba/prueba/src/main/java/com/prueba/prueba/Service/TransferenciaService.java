package com.prueba.prueba.Service;

import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.Entity.Transferencia;
import com.prueba.prueba.IService.ITransferenciaService;
import com.prueba.prueba.Repository.TransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TransferenciaService implements ITransferenciaService {

//    @Autowired
    private final TransaccionesRepository transaccionesRepository;

    public TransferenciaService(TransaccionesRepository transaccionesRepository) {
        this.transaccionesRepository = transaccionesRepository;
    }

    @Override
    public Transferencia save(TransferenciaDto dto) throws Exception {
        Transferencia transferencia = new Transferencia();

        Productos origen = new Productos();
        origen.setId(dto.getCuentaOrigen());

        Productos destino = new Productos();
        destino.setId(dto.getCuentaDestino());

        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        transferencia.setValorTransferencia(dto.getValor());

        // Zona horaria de Bogotá
        ZonedDateTime bogotaNow = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        transferencia.setFechaCreacion(bogotaNow.toLocalDateTime());

        return transaccionesRepository.save(transferencia);
    }


}
