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

import static java.util.Objects.isNull;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/EscuelaEnLinea/V.1.0.0/acudiente")
public class AcudienteController {
    private final AcudienteService acudienteService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String nombre,
                                     @RequestParam(required = false) String apellido,
                                     @RequestParam(required = false) String identificacion){
        try {
            if (!isNull(nombre) && !isNull(apellido) && !isNull(identificacion)){
                return new ResponseEntity<>("Solo debes enviar el nombre y apellido o solo la identificacion", HttpStatus.BAD_REQUEST);
            }
            if (!isNull(nombre) && !isNull(apellido)) {
                Optional<AcudienteEDto> acudienteEDto = acudienteService.findByNombreCompleto(nombre, apellido);
                return new ResponseEntity<>(acudienteEDto.get(), HttpStatus.OK);
            }
            if (!isNull(identificacion)){
                AcudienteEDto acudienteEDto = acudienteService.findByIdentifiicacion(identificacion);
                return new ResponseEntity<>(acudienteEDto, HttpStatus.OK);
            }
            List<AcudienteEDto> acudientes = acudienteService.findAll();
            if (acudientes.isEmpty()) return new ResponseEntity<>("La lista de acudientes esta vacía", HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(acudientes, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if (id != null){
            acudienteService.deleteById(id);
            return ResponseEntity.ok("Se borro correctamente el acudiente");
        }
        return new ResponseEntity<>("El id es null",HttpStatus.BAD_REQUEST);
    }
}
