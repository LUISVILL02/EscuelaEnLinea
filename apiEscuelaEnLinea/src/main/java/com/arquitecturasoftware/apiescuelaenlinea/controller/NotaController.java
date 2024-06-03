package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.NotaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.NotaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/nota")
@Validated
@AllArgsConstructor
@Tag(name = "Nota", description = "Recurso para gestionar las notas")
public class NotaController {
    private final NotaService notaService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> save(@RequestBody @Valid NotaGDto notaGDto){
        try {
            return new ResponseEntity<>(notaService.save(notaGDto), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}/{nota}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> update(@PathVariable Long id, @PathVariable Float nota){
        try {
            return new ResponseEntity<>(notaService.update(nota, id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(notaService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idAlumno}/actividad")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findByNombreAndIdAlumno(@RequestParam String nombre, @PathVariable Long idAlumno){
        try {
            if (isNull(nombre)) return new ResponseEntity<>("Se necesita el nombre de la actividad", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(notaService.findByNombreAndIdAlumno(nombre, idAlumno), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
