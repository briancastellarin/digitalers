package com.digitalers.academia.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "estudiantes")
public class Estudiante extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private LocalDate fechaDeNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactoId")
    private Contacto contacto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "estudiante_curso", joinColumns = @JoinColumn(name = "estudianteId"), inverseJoinColumns = @JoinColumn(name = "cursoId"))
    private List<Curso> cursos = new ArrayList<>();
}
