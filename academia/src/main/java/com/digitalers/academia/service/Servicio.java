package com.digitalers.academia.service;

import java.io.Serializable;
import java.util.List;

import com.digitalers.academia.dto.EntidadDTO;
import com.digitalers.academia.entity.Entidad;

public interface Servicio<T extends Entidad, I extends Serializable, D extends EntidadDTO> {

    List<EntidadDTO> findAll() throws Exception;

    EntidadDTO findById(I id) throws Exception;

    T save(T entidad) throws Exception;

    T update(I id, T entidad) throws Exception;

    Boolean delete(I id) throws Exception;

    EntidadDTO generar(T entidad);
}
