package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcudienteEDto extends UsuarioEDto {
    @NotBlank(message = "La dirección no puede estar en blanco")
    private String direccion;
}
