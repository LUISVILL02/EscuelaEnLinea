package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsistenciaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asistencia;
import org.mapstruct.*;

@Mapper
public interface AsistenciaMapper {

    @Mappings({
            @Mapping(source = "alumno.idAlumno", target = "idAlumno"),
            @Mapping(source = "estadoAsistencia.idEstadoAsistencia", target = "idEstadoAsistencia")
    })
    AsistenciaGDto toDto(Asistencia asistencia);
    @InheritInverseConfiguration
    Asistencia toAsistencia(AsistenciaGDto asistenciaDto);
}
