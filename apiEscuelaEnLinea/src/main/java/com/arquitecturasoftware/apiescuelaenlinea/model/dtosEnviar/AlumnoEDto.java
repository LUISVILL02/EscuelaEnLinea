package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoEDto {
    private Long idAlumno;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    private String apellido;

    @Email(message = "El correo debe ser una dirección de correo electrónico válida")
    private String correo;

    @NotNull(message = "El teléfono no puede ser nulo")
    private Long telefono;

    @Past(message = "La fecha de nacimiento debe ser pasada o presente")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "La dirección no puede estar en blanco")
    private String dirección;

    @NotNull(message = "La identificación no puede ser nula")
    private Long identificación;

    private String fotografia;

    @NotBlank(message = "El nombre del acudiente no puede estar en blanco")
    private String nombreAcudiente;

    @NotBlank(message = "El apellido del acudiente no puede estar en blanco")
    private String apellidoAcudiente;

    @NotBlank(message = "El nombre del curso no puede estar en blanco")
    private String nombreCurso;

    private List<AsistenciaEDto> asistencias;
    private List<NotaEDto> notas;
    private List<ObservacionEDto> observaciones;
}
