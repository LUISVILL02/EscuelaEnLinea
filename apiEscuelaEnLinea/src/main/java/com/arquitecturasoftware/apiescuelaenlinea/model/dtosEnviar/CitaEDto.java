package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaEDto {
    private Long idCita;

    @NotBlank(message = "La descripción de la cita no puede estar vacía")
    private String descripcion;

    @NotNull(message = "La fecha de creación de la cita no puede ser nula")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaCreacion;

    @NotNull(message = "La fecha de la cita no puede ser nula")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaCita;

    @NotBlank(message = "El nombre del profesor no puede estar vacío")
    private String nombreProfesor;

    @NotBlank(message = "El apellido del profesor no puede estar vacío")
    private String apellidoProfesor;

    @NotBlank(message = "El nombre del acudiente no puede estar vacío")
    private String nombreAcudiente;

    @NotBlank(message = "El apellido del acudiente no puede estar vacío")
    private String apellidoAcudiente;

    @NotBlank(message = "El estado de la cita no puede estar vacío")
    private String estadoCita;
}
