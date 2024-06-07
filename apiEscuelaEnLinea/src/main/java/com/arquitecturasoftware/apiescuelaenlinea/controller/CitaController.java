package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/EscuelaEnLinea/V.1.0.0/cita")
public class CitaController {
    private final CitaRepository citaRepository;
    CitaService citaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> save(@RequestBody CitaGDto citaGDto) {
        try {
            boolean exist = citaRepository.existsById(citaGDto.getIdCita());
            if (!exist){
                citaService.save(citaGDto);
                return new ResponseEntity<>("Se guardo correctamente", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Ya existe la cita", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/all")
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
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ACUDIENTE')")
    public ResponseEntity<?> getCitasByIdEstadoCita(@PathVariable Long id){
        try {
            return new ResponseEntity<>(citaService.findCitasByEstadoCita(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 }


