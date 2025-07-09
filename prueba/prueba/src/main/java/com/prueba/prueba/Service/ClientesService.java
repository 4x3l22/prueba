package com.prueba.prueba.Service;

import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IService.IClientesService;
import org.springframework.stereotype.Service;

@Service
public class ClientesService extends BaseService<Clientes> implements IClientesService {

    protected ClientesService(IBaseRepository<Clientes, Long> repository, AuditoriaService auditService) {
        super(repository, auditService);
    }
}
