package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoGuardarDto {
    private Long idAlumno;
    private String nombre;
    private String apellido;
    private String correo;
    private Long telefono;
    private LocalDate fechaNacimiento;
    private String dirección;
    private Long identificación;
    private String fotografia;
    private Long idAcudiente;
    private Long idCurso;
    private List<NotaGuardarDto> notas;
    private List<AsistenciaGuardarDto> asistencias;
    private List<ObservacionGuardarDto> observaciones;
}
