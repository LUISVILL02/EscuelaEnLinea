package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AcudienteService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/acudiente")
public class AcudienteController {
    private final AcudienteService acudienteService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findAll(){
        List<AcudienteEDto> acudientes = acudienteService.findAll();
        if (acudientes.isEmpty()) return new ResponseEntity<>("La lista de acudientes esta vacía", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(acudientes, HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AcudienteEDto> findByFullName(@RequestParam @NotBlank String nombre, @RequestParam @NotBlank String apellido){
        if (nombre != null && apellido != null) {
            Optional<AcudienteEDto> acudienteEDto = acudienteService.findByNombreCompleto(nombre, apellido);
            return acudienteEDto.map(eDto -> new ResponseEntity<>(eDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        if (id != null){
            Optional<AcudienteEDto> acudienteEDto = acudienteService.findById(id);
            return acudienteEDto.map(eDto -> new ResponseEntity<>(eDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
