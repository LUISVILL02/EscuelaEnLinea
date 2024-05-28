package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEDto {
    private Long idCurso;

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    @Size(max = 100, message = "El nombre del curso no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "El nombre del profesor no puede estar vacío")
    @Size(max = 100, message = "El nombre del profesor no puede tener más de 100 caracteres")
    private String nombreProfesor;

    @NotBlank(message = "El apellido del profesor no puede estar vacío")
    @Size(max = 100, message = "El apellido del profesor no puede tener más de 100 caracteres")
    private String apellidoProfesor;

    private List<AlumnoEDto> alumnos;
}
