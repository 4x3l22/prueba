package com.prueba.prueba.Service;

import com.prueba.prueba.Entity.BaseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class AuditoriaService {

    public void setAuditoriaOnCreate(BaseEntity entity){
        ZonedDateTime fechaEnBogota = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        entity.setFechaCreacion(fechaEnBogota.toLocalDateTime());
        entity.setFechaModificacion(fechaEnBogota.toLocalDateTime());
        entity.setFechaEliminacion(null);
    }

    public void setAuditoriaOnUpdate(BaseEntity entity){
        ZonedDateTime fechaEnBogota = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        entity.setFechaCreacion(fechaEnBogota.toLocalDateTime());
    }

    public void setAuditoriaOnDelete(BaseEntity entity){
        ZonedDateTime fechaEnBogota = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        entity.setFechaEliminacion(fechaEnBogota.toLocalDateTime());
    }
}
