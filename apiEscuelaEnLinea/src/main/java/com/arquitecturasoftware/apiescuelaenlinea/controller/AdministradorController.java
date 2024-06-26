package com.arquitecturasoftware.apiescuelaenlinea.controller;


import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import com.arquitecturasoftware.apiescuelaenlinea.service.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/administrador")
@Tag(name = "Administrador", description = "Recurso para gestionar los administradores")
public class AdministradorController {
    private final AdministradorService administradorService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findAll(){
        List<AdministradorEDto> administradores = administradorService.findAll();
        if (administradores.isEmpty()) {
            return new ResponseEntity<>("La lista de administradores está vacía", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener profesor por nombre completo",
            description = "Este recurso devuelve un profesor atraves de su nombre y apellido",
            tags = {"Get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CursoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdministradorEDto> findByFullName(@RequestParam  @NotBlank String nombre, @RequestParam @NotBlank String apellido){
        if (nombre != null && apellido != null){
            Optional<AdministradorEDto> administrador = administradorService.findByNombreCompleto(nombre, apellido);
            return administrador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }
@Operation(
        summary = "Obtener administrador por id",
        description = "Este recurso devuelve un administrador por su id",
        tags = {"Get"}
)
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = AdministradorEDto.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdministradorEDto> findById(@PathVariable Long id){
        if (id != null){
            Optional<AdministradorEDto> administrador = administradorService.findById(id);
            return administrador.map(eDto -> new ResponseEntity<>(eDto, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(
            summary = "Eliminar administrador por id",
            description = "Este recurso elimina un administrador por su id",
            tags = {"Delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            if (id != null){
                administradorService.deleteById(id);
                return ResponseEntity.ok("Administrador borrado correctamente");
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
