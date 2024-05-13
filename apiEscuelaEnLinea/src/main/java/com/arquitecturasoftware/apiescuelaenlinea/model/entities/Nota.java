package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fecha;
    private Integer periodo;
    private String nombreActividad;
    private Float nota;

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
