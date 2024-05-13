package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEDto {
    private Long idCurso;
    private String nombre;
    private String nombreProfesor;
}
