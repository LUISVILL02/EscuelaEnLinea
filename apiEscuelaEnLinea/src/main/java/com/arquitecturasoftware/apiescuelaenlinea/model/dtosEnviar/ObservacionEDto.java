package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionEDto {
    private Long idObservacion;
    private LocalDate fecha;
    private String descripcion;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Long idAsignacion;
}
