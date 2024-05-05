package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaGuardarDto {
    private Long idAsignatura;
    private String nombre;
    private List<AsignacionGuardarDto> asignaciones;
}
