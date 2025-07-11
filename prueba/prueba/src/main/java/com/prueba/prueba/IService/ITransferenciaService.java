package com.prueba.prueba.IService;

import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Entity.Transferencia;

public interface ITransferenciaService {

    Transferencia save(TransferenciaDto entity) throws Exception;
}
