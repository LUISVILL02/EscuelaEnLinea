package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionEDto {
    @NotNull(message = "El ID de la asignación no puede ser nulo")
    private Long idAsignacion;

    @NotBlank(message = "El nombre del profesor no puede estar en blanco")
    private String nombreProfesor;

    @NotBlank(message = "El apellido del profesor no puede estar en blanco")
    private String apellidoProfesor;

    @NotBlank(message = "El nombre de la asignatura no puede estar en blanco")
    private String nombreAsignatura;
}
