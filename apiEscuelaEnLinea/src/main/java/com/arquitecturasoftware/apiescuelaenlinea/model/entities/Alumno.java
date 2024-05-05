package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    private String nombre;
    private String apellido;
    private String correo;
    private Long telefono;
    private LocalDate fechaNacimiento;
    private String dirección;
    private Long identificación;
    private String fotografia;

    //relationship
    //acudiente
    @ManyToOne
    @JoinColumn(name = "id_acudiente")
    private Acudiente acudiente;

    //curso
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    //observaciones
    @OneToMany(mappedBy = "alumno")
    private List<Observacion> observaciones;

    //asistencias
    @OneToMany(mappedBy = "alumno")
    private List<Asistencia> asistencias;

    //notas
    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;
}
