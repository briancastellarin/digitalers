package com.digitalers.academia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cursos")
public class Curso extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;
}
