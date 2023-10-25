package com.digitalers.academia.controller;

import com.digitalers.academia.dto.EntidadDTO;
import com.digitalers.academia.entity.Entidad;
import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface Controlador<T extends Entidad, N extends Serializable, D extends EntidadDTO> {

    ResponseEntity<? extends Object> getAll();

    ResponseEntity<? extends Object> getById(@PathVariable N id);

    ResponseEntity<? extends Object> save(@RequestBody T entidad);

    ResponseEntity<? extends Object> update(@PathVariable N id, @RequestBody T entidad);

    ResponseEntity<? extends Object> delete(@PathVariable N id);
}
