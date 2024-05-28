package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaEDto {
    private Long idAsignatura;

    @NotBlank(message = "El nombre de la asignatura no puede estar en blanco")
    private String nombre;
}
