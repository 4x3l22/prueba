package com.prueba.prueba.Repository;

import com.prueba.prueba.Entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T extends BaseEntity, id> extends JpaRepository<T, Long> {
}
