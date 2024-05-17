package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseJwt> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.login(login));
    }

    @PostMapping("/register/acudiente")
    public ResponseEntity<String> registerAcudiente(@RequestBody AcudienteGDto acudienteGDto) {
        try {
            return ResponseEntity.ok(authService.registerAcudiente(acudienteGDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register/profesor")
    public ResponseEntity<String> registerProfesor(@RequestBody ProfesorGDto profesorGDto) {
        return ResponseEntity.ok(authService.registerProfesor(profesorGDto));
    }

    @PostMapping("/register/administrador")
    public ResponseEntity<String> registerAdministrador(@RequestBody AdministradorGDto administradorGDto) {
        return ResponseEntity.ok(authService.registerAdministrador(administradorGDto));
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Prueba de autorización con token válido");
    }
}
