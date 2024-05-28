package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsistenciaEDto {
    private Long idEA;

    @NotBlank(message = "El estado no puede estar vacío")
    @Size(max = 100, message = "El estado no puede tener más de 100 caracteres")
    private String estado;
}
