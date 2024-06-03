package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.NotaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.NotaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Nota;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface NotaMapper {

    @Mappings({
            @Mapping(source = "alumno.idAlumno", target = "idAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    NotaGDto toDto(Nota nota);
    @InheritInverseConfiguration
    Nota toNota(NotaGDto notaDto);

    @Mappings({
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    NotaEDto toEDto(Nota nota);
}
