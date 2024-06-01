package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsistenciaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AsistenciaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/asistencia")
@Tag(name = "asistencias", description = "Controlador para gestionar las asistencias")
public class AsistenciaController {
    private final AsistenciaService asistenciaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> save(@Valid @RequestBody AsistenciaGDto asistencia){
        try{
            return new ResponseEntity<>(asistenciaService.save(asistencia), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findAll(){
        List<AsistenciaEDto> asistencias = asistenciaService.findAll();
        if (asistencias.isEmpty()) {
            return new ResponseEntity<>("No hay ninguna asistencia", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asistencias, HttpStatus.OK);
    }
}
