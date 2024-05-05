package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import org.mapstruct.*;

@Mapper
public interface AsignacionMapper {

    @Mappings({
            @Mapping(source = "profesor.idProfesor", target = "idProfesor"),
            @Mapping(source = "asignatura.idAsignatura", target = "idAsignatura")
    })
    AsignacionGDto toDto(Asignacion asignacion);
    @InheritInverseConfiguration
    Asignacion toAsignacion(AsignacionGDto asignacionDto);
}