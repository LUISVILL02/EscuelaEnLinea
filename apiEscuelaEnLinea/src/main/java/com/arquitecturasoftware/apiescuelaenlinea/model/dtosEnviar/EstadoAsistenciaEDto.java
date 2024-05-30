package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsistenciaEDto {
    private Long idEA;
    private String estado;
}
