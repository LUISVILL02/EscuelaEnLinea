package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEDto {
    private Long idAsistencia;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String estado;
}
