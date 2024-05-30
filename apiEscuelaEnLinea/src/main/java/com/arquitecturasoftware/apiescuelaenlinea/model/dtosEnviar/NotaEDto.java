package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaEDto {
    private Long idNota;
    private LocalDate fecha;
    private Integer periodo;
    private String nombreActividad;
    private Float nota;
    private String nombreAlumno;
    private String apellidoAlumno;
    private Long idAsignacion;
}
