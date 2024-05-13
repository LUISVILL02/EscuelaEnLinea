package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.Dtos.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthImpl implements AuthService{
    @Override
    public ResponseJwt login(String correo, String contraseña) {
        return null;
    }

    @Override
    public String register(Usuario usuario) {
        return null;
    }
}
