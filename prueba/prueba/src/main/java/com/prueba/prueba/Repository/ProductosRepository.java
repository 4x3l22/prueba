package com.prueba.prueba.Repository;

import com.prueba.prueba.Entity.Productos;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductosRepository extends IBaseRepository<Productos, Long>{

    boolean existsByNumCuenta(long numCuenta);

    Optional<Productos> findByNumCuenta(Long numCuenta);

}
