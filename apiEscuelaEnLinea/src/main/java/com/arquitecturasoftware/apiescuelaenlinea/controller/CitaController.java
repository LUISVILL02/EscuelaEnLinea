package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.CitaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/EscuelaEnLinea/V.1.0.0/cita")
@Validated
@Tag(name = "Cita", description = "Recurso para gestionar las citas")
public class CitaController {
    private final CitaService citaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ACUDIENTE') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> save(@RequestBody @Valid CitaGDto citaGDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(citaGDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACUDIENTE') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok(citaService.findAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/profesor/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> getCitasByIdProfesor(@PathVariable Long id){
        try {
            return new ResponseEntity<>(citaService.findCitasByProfesor(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/acudiente/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACUDIENTE')")
    public ResponseEntity<?> getCitasByIdAcudiente(@PathVariable Long id){
        try {
            return new ResponseEntity<>(citaService.findCitasByAcudiente(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/estadoCita/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACUDIENTE') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> getCitasByIdEstadoCita(@PathVariable Long id){
        try {
            return new ResponseEntity<>(citaService.findCitasByEstadoCita(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{idCita}/{idEstadoCita}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACUDIENTE') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> updateEstadoCita(@PathVariable Long idCita, @PathVariable Long idEstadoCita){
        try {
            return ResponseEntity.ok(citaService.updateEstadoCita(idCita, idEstadoCita));
        } catch (EntityNoFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 }


