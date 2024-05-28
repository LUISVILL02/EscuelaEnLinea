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

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @PastOrPresent(message = "La fecha debe ser en el pasado o el presente")
    private LocalDate fecha;

    @NotNull(message = "El período no puede estar vacío")
    @Min(value = 1, message = "El período debe ser al menos 1")
    @Max(value = 4, message = "El período no puede ser mayor que 4")
    private Integer periodo;

    @NotBlank(message = "El nombre de la actividad no puede estar vacío")
    @Size(max = 100, message = "El nombre de la actividad no puede tener más de 100 caracteres")
    private String nombreActividad;

    @NotNull(message = "La nota no puede estar vacía")
    @DecimalMin(value = "0.0", inclusive = true, message = "La nota debe ser al menos 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "La nota no puede ser mayor que 10.0")
    private Float nota;

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 100, message = "El nombre del alumno no puede tener más de 100 caracteres")
    private String nombreAlumno;

    @NotBlank(message = "El apellido del alumno no puede estar vacío")
    @Size(max = 100, message = "El apellido del alumno no puede tener más de 100 caracteres")
    private String apellidoAlumno;

    @NotNull(message = "El ID de la asignación no puede estar vacío")
    private Long idAsignacion;
}
