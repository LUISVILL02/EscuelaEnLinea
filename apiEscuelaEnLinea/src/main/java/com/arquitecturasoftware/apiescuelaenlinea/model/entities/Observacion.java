package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "observaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObservacion;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDate fecha;
    private String descripcion;

    //relationship
    //profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    //alumno
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
}
