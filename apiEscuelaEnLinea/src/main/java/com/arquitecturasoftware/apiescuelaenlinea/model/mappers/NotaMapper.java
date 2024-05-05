package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.NotaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Nota;
import org.mapstruct.*;

@Mapper
public interface NotaMapper {

    @Mappings({
            @Mapping(source = "alumno.idAlumno", target = "idAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    NotaGDto toDto(Nota nota);
    @InheritInverseConfiguration
    Nota toNota(NotaGDto notaDto);
}
