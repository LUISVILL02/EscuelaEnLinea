package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AsignacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/asignacion")
@AllArgsConstructor
@Tag(name = "Asignacion", description = "Recurso para gestionar las asignaciones")
public class AsignacionController {
    private final AsignacionService asignacionService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveAsignacion(@RequestBody AsignacionGDto asignacion){
        try{
            return new ResponseEntity<>(asignacionService.hacerAsignacion(asignacion), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('PROFESOR')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(asignacionService.buscarAsignacion(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return new ResponseEntity<>(asignacionService.eliminarAsignacion(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
