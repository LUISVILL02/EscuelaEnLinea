package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdministradorGuardarDto extends UsuarioGuardarDto{
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fechaNacimiento;
}
