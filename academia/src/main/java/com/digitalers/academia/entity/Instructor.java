package com.digitalers.academia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "instructores")
public class Instructor extends Entidad {

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;
}
