package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ObservacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ObservacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ObservacionMapper {

    @Mappings({
        @Mapping(source = "profesor.idUser", target = "idProfesor"),
        @Mapping(source = "alumno.idAlumno", target = "idAlumno"),
        @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    ObservacionGDto toDto(Observacion observacion);
    @InheritInverseConfiguration
    Observacion toObservacion(ObservacionGDto observacionDto);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    ObservacionEDto toEDto(Observacion observacion);
}
