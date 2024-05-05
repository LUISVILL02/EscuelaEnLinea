package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaGuardarDto {
    private Long idCita;
    private String descripcion;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDateTime fechaCreacion;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDateTime fechaCita;
    private Long idProfesor;
    private Long idAcudiente;
    private Long idEstadoCita;
}
