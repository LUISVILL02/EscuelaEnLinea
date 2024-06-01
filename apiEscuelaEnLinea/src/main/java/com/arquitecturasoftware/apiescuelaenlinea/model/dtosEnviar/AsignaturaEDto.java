package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaEDto {
    private Long idAsignatura;
    private String nombre;
    List<AsignacionEDto> asignaciones;
}
