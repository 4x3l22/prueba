package com.prueba.prueba.Service;

import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IService.IProductosService;
import org.springframework.stereotype.Service;

@Service
public class ProductosService extends BaseService<Productos> implements IProductosService {

    protected ProductosService(IBaseRepository<Productos, Long> repository, AuditoriaService auditService) {
        super(repository, auditService);
    }
}
