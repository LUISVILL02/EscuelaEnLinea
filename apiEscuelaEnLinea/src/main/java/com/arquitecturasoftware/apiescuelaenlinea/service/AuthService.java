package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.Dtos.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;

public interface AuthService {
    ResponseJwt login(String correo, String contraseña);
    String register(Usuario usuario);
}
