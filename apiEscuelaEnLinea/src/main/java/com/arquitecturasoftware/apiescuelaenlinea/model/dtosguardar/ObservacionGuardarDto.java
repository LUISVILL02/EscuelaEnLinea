package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservacionGuardarDto {
    private Long idObservacion;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDate fecha;
    private String descripcion;
    private Long idProfesor;
    private Long idAlumno;
}
