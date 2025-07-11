package com.prueba.prueba.Repository;

import com.prueba.prueba.Entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transferencia, Long> {
}
