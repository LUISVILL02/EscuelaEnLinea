package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdministradorEDto extends UsuarioEDto {
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @Past(message = "La fecha de nacimiento debe ser pasada o presente")
    private LocalDate fechaNacimiento;
}
