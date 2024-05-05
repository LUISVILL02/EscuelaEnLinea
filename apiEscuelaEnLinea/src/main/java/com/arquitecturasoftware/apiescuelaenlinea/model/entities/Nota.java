package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "notas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;
    private LocalDate fecha;
    private Integer periodo;
    private String nombreActividad;

    //relationship
    //alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    //asignacion
    @ManyToOne
    @JoinColumn(name = "id_asignacion")
    private Asignacion asignacion;
}
