package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoGDto {
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
}
