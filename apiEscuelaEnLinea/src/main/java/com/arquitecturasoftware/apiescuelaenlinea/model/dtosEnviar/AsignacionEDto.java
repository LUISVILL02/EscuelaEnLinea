package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionEDto {
    private Long idAsignacion;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String nombreAsignatura;
}
