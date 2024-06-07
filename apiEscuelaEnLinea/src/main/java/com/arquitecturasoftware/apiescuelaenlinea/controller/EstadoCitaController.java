package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoCitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.EstadoCitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.EstadoCitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.EstadoCitaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/estadoCita")
@Tag(name = "Estado Cita", description = "Gestiona los estados de las citas")
public class EstadoCitaController {
    private final EstadoCitaService estadoCitaService;
    private final EstadoCitaRepository estadoCitaRepository;


    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR') or hasRole('ROLE_ACUDIENTE')")
    public ResponseEntity<?> finAll(){
        try {
            List<EstadoCitaEDto> estadosCita = estadoCitaService.findAll();
            if (estadosCita.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(estadosCita, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR') or hasRole('ROLE_ACUDIENTE')")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            if (estadoCitaRepository.existsById(id)){
                Optional<EstadoCitaEDto> estadoCita = estadoCitaService.getEstadoCita(id);
                return new ResponseEntity<>(estadoCita, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> save(@RequestBody EstadoCitaGDto estadoCitaGDto){
        try {
            Optional<EstadoCitaEDto> estado = estadoCitaService.getEstadoCita(estadoCitaGDto.getIdEstadoCita());
            if (estado.isEmpty()) {
                return new ResponseEntity<>(
                        estadoCitaService.save(estadoCitaGDto), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(estadoCitaGDto, HttpStatus.CONFLICT);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }
}
