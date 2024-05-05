package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ObservacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import org.mapstruct.*;

@Mapper
public interface ObservacionMapper {

    @Mappings({
        @Mapping(source = "profesor.idProfesor", target = "idProfesor"),
        @Mapping(source = "alumno.idAlumno", target = "idAlumno")
    })
    ObservacionGDto toDto(Observacion observacion);
    @InheritInverseConfiguration
    Observacion toObservacion(ObservacionGDto observacionDto);
}
