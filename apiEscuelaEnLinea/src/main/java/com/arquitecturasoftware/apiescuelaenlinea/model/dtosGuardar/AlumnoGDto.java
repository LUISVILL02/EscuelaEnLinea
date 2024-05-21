package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoGDto {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    private String apellido;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    private String correo;
    private String telefono;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fechaNacimiento;
    private String dirección;
    @NotBlank(message = "La identificación es obligatoria")
    private String identificación;
    private String fotografia;
    private Long idCurso;
}
