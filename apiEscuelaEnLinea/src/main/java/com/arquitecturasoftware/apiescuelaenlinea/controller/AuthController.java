package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticación", description = "Recursos de autenticación y registro de usuarios")
@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(
            summary = "Inicio de sesión",
            description = "Iniciar sesion con correo y contraseña",
            tags = { "Login", "Post" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Login.class),
                    examples = @ExampleObject(name = "Ejemplo de inicio de sesión",
                                    value = "{\n\"correo\": \"villamilluis123@gmail.com\", \n\"contraseña\": \"password123\"\n}" ,
                                    description = "Correo del usuario")
    ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseJwt.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        try {
            return ResponseEntity.ok(authService.login(login));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Registrar acudiente",
            description = "Registrar un acudiente en la base de datos",
            tags = { "Signup", "Post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @PostMapping("/register/acudiente")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerAcudiente(@RequestBody AcudienteGDto acudienteGDto) {
        try {
            return ResponseEntity.ok(authService.registerAcudiente(acudienteGDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Registrar profesor",
            description = "Registrar un profesor en la base de datos",
            tags = { "Signup", "Post" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProfesorGDto.class),
                    examples = @ExampleObject(name = "Ejemplo de inicio de sesión",
                            value = "{\n" +
                                    "  \"nombre\": \"Juan\",\n" +
                                    "  \"apellido\": \"Pérez\",\n" +
                                    "  \"identificacion\": \"12345678\",\n" +
                                    "  \"correo\": \"usuario@ejemplo.com\",\n" +
                                    "  \"telefono\": \"34123456789\",\n" +
                                    "  \"contraseña\": \"password123\",\n" +
                                    "  \"roles\": [\n" +
                                    "    \"PROFESOR\"\n" +
                                    "  ],\n" +
                                    "  \"fechaNacimiento\": \"15/09/2002\",\n" +
                                    "  \"direccion\": \"Calle Falsa 123\"\n" +
                                    "}",
                            description = "Json con los datos del profesor a guardar")
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @PostMapping("/register/profesor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerProfesor(@RequestBody ProfesorGDto profesorGDto) {
        try {
            return ResponseEntity.ok(authService.registerProfesor(profesorGDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Registrar administrador",
            description = "Registrar un administrador en la base de datos",
            tags = { "Signup", "Post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @PostMapping("/register/administrador")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerAdministrador(@RequestBody AdministradorGDto administradorGDto) {
        try {
            return ResponseEntity.ok(authService.registerAdministrador(administradorGDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
