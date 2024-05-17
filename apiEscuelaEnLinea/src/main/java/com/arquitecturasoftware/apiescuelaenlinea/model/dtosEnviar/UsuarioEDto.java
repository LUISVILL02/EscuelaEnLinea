package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEDto {
    private Long idUser;
    private String nombre;
    private String apellido;
    private String identificador;
    private String correo;
    private String telefono;
    private Set<String> roles;
}
