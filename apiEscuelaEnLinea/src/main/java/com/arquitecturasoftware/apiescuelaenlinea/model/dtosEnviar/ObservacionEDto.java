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

    @PastOrPresent(message = "La fecha debe ser en el pasado o el presente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 500, message = "La descripción no puede tener más de 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El nombre del profesor no puede estar vacío")
    @Size(max = 100, message = "El nombre del profesor no puede tener más de 100 caracteres")
    private String nombreProfesor;

    @NotBlank(message = "El apellido del profesor no puede estar vacío")
    @Size(max = 100, message = "El apellido del profesor no puede tener más de 100 caracteres")
    private String apellidoProfesor;

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 100, message = "El nombre del alumno no puede tener más de 100 caracteres")
    private String nombreAlumno;

    @NotBlank(message = "El apellido del alumno no puede estar vacío")
    @Size(max = 100, message = "El apellido del alumno no puede tener más de 100 caracteres")
    private String apellidoAlumno;
}
