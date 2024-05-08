package com.arquitecturasoftware.apiescuelaenlinea.model.dtosenviar;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaEnviarDto {
    private Long idCita;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCita;
    private String nombreProfesor;
    private String nombreAcudiente;
    private String estadoCita;
}
