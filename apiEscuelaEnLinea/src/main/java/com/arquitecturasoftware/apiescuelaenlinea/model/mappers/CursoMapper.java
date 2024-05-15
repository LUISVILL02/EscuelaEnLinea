package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import org.mapstruct.*;

@Mapper
public interface CursoMapper {

    @Mapping(source = "profesor.idUser", target = "idProfesor")
    CursoGDto toDto(Curso curso);
    @InheritInverseConfiguration
    Curso toCurso(CursoGDto cursoDto);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor")
    })
    CursoEDto toEDto(Curso curso);
}
