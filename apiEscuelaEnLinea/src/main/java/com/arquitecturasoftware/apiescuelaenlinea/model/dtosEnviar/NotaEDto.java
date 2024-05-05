package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaEDto {
    private Long idNota;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fecha;
    private Integer periodo;
    private String nombreActividad;
    private Float nota;
    private String nombreAlumno;
    private Long idAsignacion;
}
