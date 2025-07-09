package com.prueba.prueba.Service;

import com.prueba.prueba.Entity.BaseEntity;
import com.prueba.prueba.IRepository.IBaseRepository;
import com.prueba.prueba.IService.IBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

//    @Autowired
    private final IBaseRepository<T, Long> repository;

//    @Autowired
    private final AuditoriaService auditService;

    protected BaseService(IBaseRepository<T, Long> repository, AuditoriaService auditService) {
        this.repository = repository;
        this.auditService = auditService;
    }

    @Override
    public List<T> all() throws Exception{
        List<T> entities = repository.findAll();
        List<T> resul = new ArrayList<>();

        for(T item: entities){
            if(item.getFecha_eliminacion() == null){
                resul.add(item);
            }
        }
        return resul;
    }

    @Override
    public Optional<T> findById(Long id) throws Exception{
        return repository.findById(id);
    }

    @Override
    public T save(T entity) throws Exception{
        if(entity.getFecha_creacion() == null){
            auditService.setAuditoriaOnCreate(entity);
        }else{
            auditService.setAuditoriaOnUpdate(entity);
        }
        return repository.save(entity);
    }

    @Override
    public void update(Long id, T entity) throws Exception {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isEmpty()) {
            throw new Exception("No se encontró el registro");
        }
        T objetoToUpdate = optionalT.get();

        String[] ignoreProperties = { "id", "fecha_creacion", "fecha_eliminacion"};
        BeanUtils.copyProperties(entity, objetoToUpdate, ignoreProperties);
        objetoToUpdate.setFecha_creacion(objetoToUpdate.getFecha_creacion());
        auditService.setAuditoriaOnUpdate(objetoToUpdate);
        this.repository.save(objetoToUpdate);
    }

    @Override
    public void delete(Long id) throws Exception{
        Optional<T> optionalT = repository.findById(id);
        if(optionalT.isEmpty()){
            throw new Exception("No se encontro el registro");
        }
        T objetoToDelete = optionalT.get();
        auditService.setAuditoriaOnDelete(objetoToDelete);
        repository.save(objetoToDelete);
    }
}
