package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String idenficador;
}
