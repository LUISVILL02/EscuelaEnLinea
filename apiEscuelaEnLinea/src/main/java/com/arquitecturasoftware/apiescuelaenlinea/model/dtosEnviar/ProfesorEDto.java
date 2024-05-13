package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorEDto extends UsuarioEDto{
    private LocalDate fechaNacimiento;
    private String direccion;
}
