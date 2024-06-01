package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEDto {
    private Long idCurso;
    private String nombre;
    private String nombreProfesor;
    private String apellidoProfesor;
    private List<AlumnoEDto> alumnos;
    private List<AsignacionEDto> asignaciones;
}
