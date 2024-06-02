package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfesorEDto extends UsuarioEDto {
    private LocalDate fechaNacimiento;
    private String direccion;
    List<CursoEDto> cursos;
    List<AsignacionEDto> asignaciones;
}
