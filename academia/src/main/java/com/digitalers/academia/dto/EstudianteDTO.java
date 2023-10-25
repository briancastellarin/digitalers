package com.digitalers.academia.dto;

import java.util.List;

import com.digitalers.academia.entity.Contacto;
import com.digitalers.academia.entity.Curso;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EstudianteDTO implements EntidadDTO {
    private final String nombreCompleto;
    private final int edad;
    private final Contacto contacto;
    private final List<Curso> cursos;
}
