package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcudienteEDto extends UsuarioEDto {
    private String direccion;
}
