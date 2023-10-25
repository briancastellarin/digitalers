package com.digitalers.academia.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.academia.dto.EntidadDTO;
import com.digitalers.academia.dto.EstudianteDTO;
import com.digitalers.academia.entity.Estudiante;
import com.digitalers.academia.repository.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements Servicio<Estudiante, Long, EstudianteDTO> {

    @Autowired
    EstudianteRepositorio repositorio;

    @Override
    public List<EntidadDTO> findAll() throws Exception {
        try {
            List<EntidadDTO> estudiantesDTOs = new ArrayList<>();
            List<Estudiante> estudiantes = repositorio.findAll();
            for (Estudiante estudiante : estudiantes) {
                estudiantesDTOs.add(generar(estudiante));
            }
            return estudiantesDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public EntidadDTO findById(Long id) throws Exception {
        try {
            Optional<Estudiante> estudiante = repositorio.findById(id);
            return generar(estudiante.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante save(Estudiante entidad) throws Exception {
        try {
            return repositorio.save(entidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Estudiante update(Long id, Estudiante entidad) throws Exception {
        try {
            Optional<Estudiante> optional = repositorio.findById(id);
            Estudiante estudiante = optional.get();
            estudiante = repositorio.save(entidad);
            return estudiante;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return Boolean.TRUE;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public EntidadDTO generar(Estudiante entidad) {
        return new EstudianteDTO(entidad.getNombre().concat(" ").concat(entidad.getApellido()),
                Period.between(entidad.getFechaDeNacimiento(), LocalDate.now()).getYears(), entidad.getContacto(),
                entidad.getCursos());
    }

}
