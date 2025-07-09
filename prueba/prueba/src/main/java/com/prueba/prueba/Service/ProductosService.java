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

    @Override
    public Productos save(Productos productos) throws Exception{

        if(!esCuentaValida(productos.getTip_cuenta())){
            throw new Exception("El cuenta no es valida");
        }
        return super.save(productos);
    }

    private boolean esCuentaValida(String cuenta) {
        if (cuenta == null) return false;
        return cuenta.equalsIgnoreCase("corriente") || cuenta.equalsIgnoreCase("ahorros");
    }

}
