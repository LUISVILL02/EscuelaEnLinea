package com.arquitecturasoftware.apiescuelaenlinea.controller;


import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AdministradorService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/administrador")
public class AdministradorController {
    private final AdministradorService administradorService;

    @GetMapping("/all")
    public ResponseEntity<List<AdministradorEDto>> findAll(){
        List<AdministradorEDto> administradores = administradorService.findAll();
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    @GetMapping("/buscarNombreCompleto")
    public ResponseEntity<AdministradorEDto> findByFullName(@RequestParam  @NotBlank String nombre, @RequestParam @NotBlank String apellido){
        if (nombre != null && apellido != null){
            Optional<AdministradorEDto> administrador = administradorService.findByNombreCompleto(nombre, apellido);
            return administrador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorEDto> findById(@RequestParam Long id){
        if (id != null){
            Optional<AdministradorEDto> administrador = administradorService.findById(id);
            return administrador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        if (id != null){
            administradorService.deleteById(id);
            return ResponseEntity.ok("Administrador borrado correctamente");
        }
        return ResponseEntity.notFound().build();
    }
}
