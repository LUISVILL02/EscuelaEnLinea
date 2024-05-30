package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaGDto {
    private Long idAsignatura;

    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    @Size(max = 100, message = "El nombre de la asignatura no puede tener más de 100 caracteres")
    private String nombre;
}
