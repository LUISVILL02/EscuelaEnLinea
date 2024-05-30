package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 100, message = "La dirección no puede tener más de 100 caracteres")
    private String direccion;
}
