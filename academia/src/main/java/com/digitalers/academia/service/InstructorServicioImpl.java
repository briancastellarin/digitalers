package com.digitalers.academia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalers.academia.dto.EntidadDTO;
import com.digitalers.academia.dto.InstructorDTO;
import com.digitalers.academia.entity.Instructor;
import com.digitalers.academia.repository.InstructorRepositorio;

@Service
public class InstructorServicioImpl implements Servicio<Instructor, Long, InstructorDTO> {

    @Autowired
    InstructorRepositorio repositorio;

    @Override
    public List<EntidadDTO> findAll() throws Exception {
        try {
            List<EntidadDTO> instructoresDTOs = new ArrayList<>();
            List<Instructor> instructores = repositorio.findAll();
            for (Instructor instructor : instructores) {
                instructoresDTOs.add(generar(instructor));
            }
            return instructoresDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public EntidadDTO findById(Long id) throws Exception {
        try {
            Optional<Instructor> instructor = repositorio.findById(id);
            return generar(instructor.get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Instructor save(Instructor entidad) throws Exception {
        try {
            return repositorio.save(entidad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Instructor update(Long id, Instructor entidad) throws Exception {
        try {
            Optional<Instructor> optional = repositorio.findById(id);
            Instructor instructor = optional.get();
            instructor = repositorio.save(entidad);
            return instructor;
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
    public EntidadDTO generar(Instructor entidad) {
        return new InstructorDTO(entidad.getNombre().concat(" ").concat(entidad.getApellido()));
    }

}
