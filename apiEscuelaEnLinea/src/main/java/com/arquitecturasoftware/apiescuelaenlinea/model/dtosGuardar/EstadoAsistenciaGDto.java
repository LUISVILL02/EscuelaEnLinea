package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.EEstadoAsistencia;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsistenciaGDto {
    private Long idEstadoAsistencia;
    private EEstadoAsistencia estado;
}
