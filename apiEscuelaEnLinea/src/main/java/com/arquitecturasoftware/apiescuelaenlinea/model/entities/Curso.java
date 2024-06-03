package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String nombre;

    //relationship

    //alumno
    @OneToMany(mappedBy = "curso")
    private List<Alumno> alumnos;

    //Asignacion
    @OneToMany(mappedBy = "curso")
    private List<Asignacion> asignaciones;

    //profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
}
