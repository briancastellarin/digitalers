package com.digitalers.academia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CursoDTO implements EntidadDTO {

    private final String nombre;
    private final String instructor;
}
