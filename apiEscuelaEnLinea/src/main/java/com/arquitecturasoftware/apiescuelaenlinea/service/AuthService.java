package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;

public interface AuthService {
    ResponseJwt login(String correo, String contraseña);
    String registerAcudiente(AcudienteGDto acudienteGDto);
    String registerProfesor(ProfesorGDto profesorGDto);
    String registerAdministrador(AdministradorGDto administradorGDto);
}
