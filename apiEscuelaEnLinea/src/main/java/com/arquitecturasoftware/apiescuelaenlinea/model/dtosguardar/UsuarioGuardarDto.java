package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGuardarDto {
    private Long idUser;
    private String nombre;
    private String apellido;
    private Long identificacion;
    private String correo;
    private String telefono;
    private String contraseña;
}
