package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfesorGDto extends UsuarioGDto {
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @Schema(description = "Fecha de nacimiento del profesor en formato dd/MM/yyyy", example = "15/09/2002")
    private LocalDate fechaNacimiento;
    private String direccion;
}
