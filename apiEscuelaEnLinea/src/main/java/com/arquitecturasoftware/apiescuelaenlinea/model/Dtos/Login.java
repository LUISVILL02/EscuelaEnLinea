package com.arquitecturasoftware.apiescuelaenlinea.model.Dtos;

import lombok.Data;

@Data
public class Login {
    private String correo;
    private String contraseña;
}
