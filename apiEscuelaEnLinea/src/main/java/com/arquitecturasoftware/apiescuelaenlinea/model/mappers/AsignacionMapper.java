package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AsignacionMapper {

    @Mappings({
            @Mapping(source = "profesor.idUser", target = "idProfesor"),
            @Mapping(source = "asignatura.idAsignatura", target = "idAsignatura"),
           })
    AsignacionGDto toDto(Asignacion asignacion);
    @InheritInverseConfiguration
    Asignacion toAsignacion(AsignacionGDto asignacionDto);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "asignatura.nombre", target = "nombreAsignatura"),
            @Mapping(source = "curso.nombre", target = "nombreCurso")
    })
    AsignacionEDto toEDto(Asignacion asignacion);
}