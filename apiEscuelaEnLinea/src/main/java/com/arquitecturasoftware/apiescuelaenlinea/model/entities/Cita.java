package com.arquitecturasoftware.apiescuelaenlinea.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCita;

    //relationship
    //profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    //acudiente
    @ManyToOne
    @JoinColumn(name = "id_acudiente")
    private Acudiente acudiente;

    //estadoCita
    @ManyToOne
    @JoinColumn(name = "idEstadoCita")
    private EstadoCita estadoCita;
}
