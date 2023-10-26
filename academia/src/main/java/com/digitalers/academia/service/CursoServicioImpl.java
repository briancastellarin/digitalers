package com.digitalers.academia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.academia.dto.CursoDTO;
import com.digitalers.academia.dto.EntidadDTO;
import com.digitalers.academia.entity.Curso;
import com.digitalers.academia.repository.CursoRepositorio;

@Service
public class CursoServicioImpl implements Servicio<Curso, Long, CursoDTO> {

    @Autowired
    CursoRepositorio repositorio;

    @Override
    public List<Curso> findAll() throws Exception {
        try {
            return repositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Curso findById(Long id) throws Exception {
        try {
            Optional<Curso> curso = repositorio.findById(id);
            return curso.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<EntidadDTO> findAllDTO() throws Exception {
        try {
            List<EntidadDTO> cursosDTOs = new ArrayList<>();
            List<Curso> cursos = repositorio.findAll();
            for (Curso curso : cursos) {
                cursosDTOs.add(generar(curso));
            }
            return cursosDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public EntidadDTO findByIdDTO(Long id) throws Exception {
        try {
            Optional<Curso> curso = repositorio.findById(id);
            return generar(curso.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Curso save(Curso entidad) throws Exception {
        try {
            return repositorio.save(entidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Curso update(Long id, Curso entidad) throws Exception {
        try {
            Optional<Curso> optional = repositorio.findById(id);
            Curso curso = optional.get();
            curso = repositorio.save(entidad);
            return curso;
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
    public EntidadDTO generar(Curso entidad) {
        return new CursoDTO(entidad.getNombre(), String.format("%s %s", entidad.getInstructor().getNombre(),
                entidad.getInstructor().getApellido()));
    }

}
