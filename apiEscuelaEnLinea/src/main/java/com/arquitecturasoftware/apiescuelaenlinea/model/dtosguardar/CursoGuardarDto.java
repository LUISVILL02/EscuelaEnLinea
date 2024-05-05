package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoGuardarDto {
    private Long idCurso;
    private String nombre;
    private List<AlumnoGuardarDto> alumnos;
    private Long idProfesor;
}
