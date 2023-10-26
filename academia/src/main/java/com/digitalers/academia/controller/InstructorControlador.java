package com.digitalers.academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalers.academia.dto.InstructorDTO;
import com.digitalers.academia.entity.Instructor;
import com.digitalers.academia.service.InstructorServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class InstructorControlador implements Controlador<Instructor, Long, InstructorDTO> {

    @Autowired
    InstructorServicioImpl servicio;

    @GetMapping("/instructores")
    @Override
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"No se pudo obtener resultados.\"}");
        }
    }

    @GetMapping("/instructor/{id}")
    @Override
    public ResponseEntity<?> getById(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("{\"error\":\"No se pudo obtener informacion para el id: %d\"}", id));
        }
    }

    @GetMapping("/instructores/dto")
    @Override
    public ResponseEntity<?> getAllDTOs() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAllDTO());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"No se pudo obtener resultados.\"}");
        }
    }

    @GetMapping("/instructor/dto/{id}")
    @Override
    public ResponseEntity<?> getByIdDTO(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByIdDTO(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("{\"error\":\"No se pudo obtener informacion para el id: %d\"}", id));
        }
    }

    @PostMapping("/instructor")
    @Override
    public ResponseEntity<?> save(Instructor entidad) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"No se pudieron guardar los datos\"}");
        }
    }

    @PutMapping("/instructor/{id}")
    @Override
    public ResponseEntity<?> update(Long id, Instructor entidad) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entidad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"No se pudieron actualizar los datos solicitados\"}");
        }
    }

    @DeleteMapping("/instructor/{id}")
    @Override
    public ResponseEntity<?> delete(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    String.format("{\"error\":\"No se pudo eliminar la informacion relacionada al id: %d\"}", id));
        }
    }

}
