package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCitaGDto {
    private Long idEstadoCita;

    @NotBlank(message = "El nombre del estado es obligatorio")
    @Size(max = 100, message = "El nombre del estado no puede tener más de 100 caracteres")
    private String nombre;
}
