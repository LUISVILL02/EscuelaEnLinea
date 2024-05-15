package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaEDto {
    private Long idCita;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCita;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String nombreAcudiente;
    private String apellidoAcudiente;
    private String estadoCita;
}
