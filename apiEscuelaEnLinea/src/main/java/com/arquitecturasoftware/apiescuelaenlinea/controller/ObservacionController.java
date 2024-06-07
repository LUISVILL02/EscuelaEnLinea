package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ObservacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.ObservacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("EscuelaEnLinea/V.1.0.0/observacion")
@Validated
@AllArgsConstructor
@Tag(name = "Observacion", description = "Recursos para gestionar las observaciones de los alumnos")
public class ObservacionController {
    private final ObservacionService observacionService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> save(@RequestBody @Valid ObservacionGDto observacionGDto){
        try {
            return new ResponseEntity<>(observacionService.save(observacionGDto), HttpStatus.CREATED);
        } catch (EntityNoFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(observacionService.findById(id), HttpStatus.OK);
        } catch (EntityNoFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @NotBlank String descripcion){
        try {
            return new ResponseEntity<>(observacionService.update(id, descripcion), HttpStatus.OK);
        } catch (EntityNoFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            observacionService.delete(id);
            return ResponseEntity.ok("Observacion eliminada con éxito");
        } catch (EntityNoFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findAll(@RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Integer size){
        if(isNull(page) || isNull(size)){ page = 0; size = 20; }
        return new ResponseEntity<>(observacionService.findAll(page, size), HttpStatus.OK);
    }
}
