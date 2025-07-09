package com.prueba.prueba.Service;

import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IService.IClientesService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ClientesService extends BaseService<Clientes> implements IClientesService {

    protected ClientesService(IBaseRepository<Clientes, Long> repository, AuditoriaService auditService) {
        super(repository, auditService);
    }

    @Override
    public Clientes save(Clientes cliente) throws Exception {
        if (!esMayorDeEdad(cliente.getFecha_nacimiento())) {
            throw new Exception("El cliente no puede ser creado porque es menor de edad.");
        }

        String correo = cliente.getEmail();
        if(!esEmailValido(correo)){
            throw new Exception("El correo electrónico no es válido.");
        }

        return super.save(cliente);
    }

    private boolean esMayorDeEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null) return false;

        // Convertir Date a LocalDate
        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant()
                .atZone(ZoneId.of("America/Bogota"))
                .toLocalDate();

        LocalDate hoy = LocalDate.now(ZoneId.of("America/Bogota"));

        Period edad = Period.between(fechaNacimientoLocal, hoy);

        return edad.getYears() >= 18;
    }

    private boolean esEmailValido(String correo) {
        if (correo == null) return false;
        return correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
