package com.arquitecturasoftware.apiescuelaenlinea.model.dtosenviar;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoEnviarDto {
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
    private List<Float> notas;
}
