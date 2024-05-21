package com.arquitecturasoftware.apiescuelaenlinea.controller;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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

@Tag(name = "Alumno", description = "Recurso para gestionar los alumnos")
@RestController
@RequestMapping("/EscuelaEnLinea/V.1.0.0/alumno")
@AllArgsConstructor
@Validated
public class AlumnoController {
    private final AlumnoService alumnoService;


    @Operation(
            summary = "Guardar un Alumno",
            description = "Guardar un alumno en la base de datos",
            tags = { "Post" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Login.class),
                    examples = @ExampleObject(name = "Ejemplo de inicio de sesión",
                            value = "{\n" +
                                    "  \"nombre\": \"Juan\",\n" +
                                    "  \"apellido\": \"Pérez\",\n" +
                                    "  \"correo\": \"usuario@ejemplo.com\",\n" +
                                    "  \"telefono\": \"34123456789\",\n" +
                                    "  \"fechaNacimiento\": \"15/09/2002\",\n" +
                                    "  \"direccion\": \"Calle Falsa 123\",\n" +
                                    "  \"identificacion\": \"12345678\",\n" +
                                    "  \"fotografia\": \"url/fotografia.jpg\",\n" +
                                    "  \"idCurso\": 0\n" +
                                    "}",
                            description = "Json con los datos del alumno a guardar")
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = AlumnoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveAlumno(@Valid @RequestBody AlumnoGDto alumno){
        try{
            return new ResponseEntity<>(alumnoService.saveAlumno(alumno), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<AlumnoEDto>> getAlumnos(){
        return new ResponseEntity<>(alumnoService.getAlumnos(), HttpStatus.OK);
    }

    @Operation(
            summary = "Obtener alumnos por id",
            description = "Este recurso devuelve un alumno por su id",
            tags = {"Get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = AlumnoEDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAlumnoById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(alumnoService.getAlumnoById(id), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Eliminar alumnos por id",
            description = "Este recurso elimina un alumno por su id",
            tags = {"Delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") })})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteAlumno(@PathVariable Long id){
        try {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok("Alumno borrado correctamente");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
            summary = "Actualizar un Alumno",
            description = "Actualizar un alumno en la base de datos",
            tags = { "Put" })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Login.class),
                    examples = @ExampleObject(name = "Ejemplo de inicio de sesión",
                            value = "{\n" +
                                    "  \"nombre\": \"Juan\",\n" +
                                    "  \"apellido\": \"Pérez\",\n" +
                                    "  \"correo\": \"usuario@ejemplo.com\",\n" +
                                    "  \"telefono\": \"34123456789\",\n" +
                                    "  \"fechaNacimiento\": \"15/09/2002\",\n" +
                                    "  \"direccion\": \"Calle Falsa 123\",\n" +
                                    "  \"identificacion\": \"12345678\",\n" +
                                    "  \"fotografia\": \"url/fotografia.jpg\",\n" +
                                    "  \"idCurso\": 0\n" +
                                    "}",
                            description = "Json con los datos del alumno a actualizar")
            ))
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AlumnoEDto> updateAlumno(@Valid @RequestBody AlumnoGDto alumno, @PathVariable Long id){
        return new ResponseEntity<>(alumnoService.updateAlumno(alumno, id), HttpStatus.OK);
    }
}
