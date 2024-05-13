package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaGDto {
    private Long idAsistencia;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDate fecha;
    private Long idAlumno;
    private Long idEstadoAsistencia;
}
