package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ProfesorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.ProfesorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/profesor")
@Tag(name = "Profesor", description = "Recurso para gestionar los profesores")
public class ProfesorController {
    private ProfesorService profesorService;

    @GetMapping("/{nombre}{apellido}")
    public ResponseEntity<ProfesorEDto> findByFullName(@RequestParam @NotBlank @PathVariable String nombre, @RequestParam @NotBlank @PathVariable  String apellido){
        if (nombre != null && apellido != null){
            Optional<ProfesorEDto> profesor = profesorService.findByNombreCompleto(nombre, apellido);
            return profesor.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }
}
