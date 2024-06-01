package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoAsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.EstadoAsistenciaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/EscuelaEnLinea/V.1.0.0/estadoAsistencia")
@Tag(name = "Estado asistencia", description = "Recurso para gestionar un estado asistencia")
public class EstadoAsistenciaController {
    private final EstadoAsistenciaService estadoAsistenciaService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> findAll(){
        List<EstadoAsistenciaEDto> estadoAsistenciaEDtos = estadoAsistenciaService.findAll();
        if (estadoAsistenciaEDtos.isEmpty()){
            return new ResponseEntity<>("La lista de estados esta vacia", HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(estadoAsistenciaEDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<EstadoAsistenciaEDto> findById(@PathVariable Long id){
        if (id != null){
            Optional<EstadoAsistenciaEDto> estadoAsistenciaEDto = estadoAsistenciaService.findById(id);
            return estadoAsistenciaEDto.map(eDto -> new ResponseEntity<>(eDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


