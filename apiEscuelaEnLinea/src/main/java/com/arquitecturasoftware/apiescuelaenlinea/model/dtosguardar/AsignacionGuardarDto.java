package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionGuardarDto {
    private Long idAsignacion;
    private Long idProfesor;
    private Long idAsignatura;
    private List<NotaGuardarDto> notas;
}
