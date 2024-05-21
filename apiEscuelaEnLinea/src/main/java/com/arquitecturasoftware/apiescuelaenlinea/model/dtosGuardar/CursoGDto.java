package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoGDto {
    @NotBlank(message = "El nombre del curso es requerido")
    @Size(min = 3, max = 50)
    private String nombre;
    private Long idProfesor;
}
