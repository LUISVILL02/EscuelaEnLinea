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

    @NotNull(message = "La fecha de la asistencia no puede ser nula")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    private String nombreAlumno;

    @NotBlank(message = "El apellido del alumno no puede estar vacío")
    private String apellidoAlumno;

    @NotBlank(message = "El estado de la asistencia no puede estar vacío")
    private String estado;
}
