package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;


import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGDto {
    private Long idUser;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String correo;
    private String telefono;
    private String contraseña;
    private Set<String> roles;
}
