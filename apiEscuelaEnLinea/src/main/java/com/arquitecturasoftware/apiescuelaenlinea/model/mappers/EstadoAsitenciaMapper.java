package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoAsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.EstadoAsistenciaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoAsistencia;
import org.mapstruct.*;

@Mapper
public interface EstadoAsitenciaMapper {
    EstadoAsistenciaGDto toDto(EstadoAsistencia estadoAsistencia);
    @InheritInverseConfiguration
    EstadoAsistencia toEstadoAsistencia(EstadoAsistenciaGDto estadoAsitenciaDto);

    @Mappings({
            @Mapping(source = "estadoAsitencia.idEstadoAsistencia", target = "idEA"),
            @Mapping(source = "estadoAsistencia.nombre", target = "nombre")
    })
    EstadoAsistenciaEDto toEDto(EstadoAsistencia estadoAsistencia);
}
