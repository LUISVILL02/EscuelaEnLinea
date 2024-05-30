package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCitaEDto {
    private Long idEstadoCita;
    private String nombre;
}
