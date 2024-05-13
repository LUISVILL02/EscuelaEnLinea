package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionGDto {
    private Long idAsignacion;
    private Long idProfesor;
    private Long idAsignatura;
}
