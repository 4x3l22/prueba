package com.prueba.prueba.Controller;

import com.prueba.prueba.Entity.BaseEntity;
import com.prueba.prueba.Service.BaseService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public abstract class BaseController<T extends BaseEntity> {

//    @Autowired
    private final BaseService<T> baseService;

    protected BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public List<T> all() throws Exception{
        return baseService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<T>> findById(@PathVariable Long id) throws Exception{
        Optional<T> entity = baseService.findById(id);
        if(entity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entity);
        }
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) throws Exception{
        try {
            T saveEntity = baseService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveEntity);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(entity);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody T entity) {
        try {
            baseService.update(id, entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el registro con ID " + id + ": " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception{
        baseService.delete(id);
    }
}
