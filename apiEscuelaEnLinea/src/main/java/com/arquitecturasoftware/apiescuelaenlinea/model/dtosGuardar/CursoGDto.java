package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoGDto {
    @NotBlank(message = "El nombre del curso es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre del curso debe tener entre 3 y 50 caracteres")
    private String nombre;

    private Long idProfesor;
}
