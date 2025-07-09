package com.prueba.prueba.IRepository;

import com.prueba.prueba.Entity.Clientes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientesRepository extends IBaseRepository<Clientes, Long>{

//    @Override
//    Optional<Clientes> findById(Long aLong);
//    @Query("")
}