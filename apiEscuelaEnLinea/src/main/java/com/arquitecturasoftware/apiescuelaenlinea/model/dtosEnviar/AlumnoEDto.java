package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoEDto {
    private Long idAlumno;
    private String nombre;
    private String apellido;
    private String correo;
    private Long telefono;
    private LocalDate fechaNacimiento;
    private String dirección;
    private Long identificación;
    private String fotografia;
    private String NombreAcudiente;
    private String apellidoAcudiente;
    private String nombreCurso;

    private List<AsistenciaEDto> asistencias;
    private List<NotaEDto> notas;
    private List<ObservacionEDto> observaciones;
}
