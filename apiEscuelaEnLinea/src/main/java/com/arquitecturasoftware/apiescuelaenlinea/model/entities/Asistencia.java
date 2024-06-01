package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "asistencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;
    private LocalDate fecha;

    //relationship

    //alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    //estadoAsistencia
    @ManyToOne
    @JoinColumn(name = "id_estado_asistencia")
    private EstadoAsistencia estadoAsistencia;

    //Asignacion
    @ManyToOne
    @JoinColumn(name = "id_asignacion")
    private Asignacion asignacion;

}
