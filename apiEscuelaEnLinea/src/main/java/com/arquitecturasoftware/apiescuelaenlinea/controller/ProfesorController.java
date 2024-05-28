package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ProfesorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.ProfesorService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/EscuelaEnLinea/V.1.0.0/profesor")
@Tag(name = "Profesor", description = "Recurso para gestionar los profesores")
public class ProfesorController {
    private ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<ProfesorEDto> findByFullName(@RequestParam @NotBlank String nombre, @RequestParam @NotBlank  String apellido){
        if (nombre != null && apellido != null){
            Optional<ProfesorEDto> profesor = profesorService.findByNombreCompleto(nombre, apellido);
            return profesor.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <?> findById(@RequestParam @NotBlank @PathVariable Long id){
        try {
            return new ResponseEntity<>(profesorService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<ProfesorEDto> profesores = profesorService.findAll();
        if(profesores.isEmpty()) return new ResponseEntity<>(profesores, HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if (id != null){
            profesorService.deleteById(id);
            return ResponseEntity.ok("profesor borrado correctamente");
        }
        return ResponseEntity.notFound().build();
    }

}
