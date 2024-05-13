package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoGDto {
    private Long idCurso;
    private String nombre;
    private Long idProfesor;
}
