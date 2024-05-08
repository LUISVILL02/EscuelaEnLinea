package com.arquitecturasoftware.apiescuelaenlinea.model.dtosenviar;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEnviarDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String idenficador;
}
