package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcudienteGDto extends UsuarioGDto {
    private String direccion;
}
