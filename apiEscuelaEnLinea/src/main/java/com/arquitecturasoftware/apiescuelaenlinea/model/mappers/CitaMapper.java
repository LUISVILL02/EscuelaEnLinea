package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Cita;
import org.mapstruct.*;

@Mapper
public interface CitaMapper {

    @Mappings({
            @Mapping(source = "profesor.idProfesor", target = "idProfesor"),
            @Mapping(source = "acudiente.idAcudiente", target = "idAcudiente"),
            @Mapping(source = "estadoCita.idEstadoCita", target = "idEstadoCita"),
            })
    CitaGDto toDto(Cita cita);
    @InheritInverseConfiguration
    Cita toCita(CitaGDto citaDto);

    @Mappings({
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "estadoAsitencia.nombre", target = "nombreEstadoAsistencia")
    })
    CitaEDto toEDto(Cita cita);
}