package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.EEstadoAsistencia;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsistenciaGuardarDto {
    private Long idEstadoAsistencia;
    private EEstadoAsistencia estado;
    private List<AsistenciaGuardarDto> asistencias;
}
