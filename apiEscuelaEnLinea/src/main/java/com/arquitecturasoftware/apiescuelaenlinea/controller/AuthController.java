package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseJwt> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.login(login.getCorreo(), login.getContraseña()));
    }

    @PostMapping("/register/acudiente")
    public ResponseEntity<String> registerAcudiente(@RequestBody AcudienteGDto acudienteGDto) {
        return ResponseEntity.ok(authService.registerAcudiente(acudienteGDto));
    }

    @PostMapping("/register/profesor")
    public ResponseEntity<String> registerProfesor(@RequestBody ProfesorGDto profesorGDto) {
        return ResponseEntity.ok(authService.registerProfesor(profesorGDto));
    }

    @PostMapping("/register/administrador")
    public ResponseEntity<String> registerAdministrador(@RequestBody AdministradorGDto administradorGDto) {
        return ResponseEntity.ok(authService.registerAdministrador(administradorGDto));
    }
}
