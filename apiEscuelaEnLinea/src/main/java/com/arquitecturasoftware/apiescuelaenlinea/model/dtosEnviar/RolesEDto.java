package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesEDto {
    private Long id;
    private String name;
}
