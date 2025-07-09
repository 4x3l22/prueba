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
        entity.setFecha_creacion(fechaEnBogota.toLocalDateTime());
        entity.setFecha_modificacion(fechaEnBogota.toLocalDateTime());
        entity.setFecha_eliminacion(null);
    }

    public void setAuditoriaOnUpdate(BaseEntity entity){
        ZonedDateTime fechaEnBogota = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        entity.setFecha_creacion(fechaEnBogota.toLocalDateTime());
    }

    public void setAuditoriaOnDelete(BaseEntity entity){
        ZonedDateTime fechaEnBogota = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        entity.setFecha_eliminacion(fechaEnBogota.toLocalDateTime());
    }
}
