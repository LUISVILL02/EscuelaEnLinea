package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionEDto {
    private Long idObservacion;
    private LocalDate fecha;
    private String descripcion;
    private String nombreProfesor;
    private String nombreAlumno;
    private String apellidoAlumno;

}
