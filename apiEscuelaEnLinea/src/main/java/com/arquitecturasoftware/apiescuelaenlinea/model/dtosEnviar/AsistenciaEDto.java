package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEDto {
    private Long idAsistencia;
    private LocalDate fecha;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String nombreEstadoAsistencia;
}
