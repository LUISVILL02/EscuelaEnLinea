package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Curso", description = "Recursos del modulo curso")
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/curso")
public class CursoController {
    private final CursoService cursoService;

    @Operation(
            summary = "Guardar curso",
            description = "Guardar un curso en la base de datos",
            tags = { "Curso", "Post" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(schema = @Schema(implementation = CursoGDto.class)),
            description = "Curso a guardar",
            required = true)
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CursoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })
    })
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveCurso(@Valid @RequestBody CursoGDto curso){
        try{
            return new ResponseEntity<>(cursoService.guardarCurso(curso), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<CursoEDto>> getCursos(){
        return new ResponseEntity<>(cursoService.listarCursos(), HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener cursos por id",
            description = "Este recurso devuelve un curso por su id",
            tags = {"Get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CursoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> getCursoById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(cursoService.buscarCurso(id), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Eliminar cursos por id",
            description = "Este recurso elimina un curso por su id",
            tags = {"Delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id){
        try {
            cursoService.eliminarCurso(id);
            return ResponseEntity.ok("Curso borrado correctamente");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/promedio/{id}")
    @PreAuthorize("hasRole('ROLE_PROFESOR')")
    public ResponseEntity<Double> promedioNotas(@PathVariable Long id){
        return new ResponseEntity<>(cursoService.promedioNotas(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener cursos por su nombre",
            description = "Este recurso devuelve un curso por su nombre",
            tags = {"Get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CursoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @GetMapping("/nombre")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROFESOR')")
    public ResponseEntity<?> getCursoByNombre(@RequestParam(required = false) String nombre){
        try {
            if (nombre == null){
                return ResponseEntity.badRequest().body("El nombre no puede estar vacio");
            }
            return new ResponseEntity<>(cursoService.buscarCursoPorNombre(nombre), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
