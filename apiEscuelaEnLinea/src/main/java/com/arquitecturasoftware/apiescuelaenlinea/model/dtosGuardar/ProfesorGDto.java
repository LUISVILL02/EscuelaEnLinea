package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfesorGDto extends UsuarioGDto {
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fechaNacimiento;
    private String direccion;
}
