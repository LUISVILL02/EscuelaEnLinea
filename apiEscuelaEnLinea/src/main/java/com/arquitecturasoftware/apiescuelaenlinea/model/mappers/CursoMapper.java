package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import org.mapstruct.*;

@Mapper
public interface CursoMapper {

    @Mapping(source = "profesor.idProfesor", target = "idProfesor")
    CursoGDto toDto(Curso curso);
    @InheritInverseConfiguration
    Curso toCurso(CursoGDto cursoDto);

    @Mapping(source = "profesor.nombre", target = "nombreProfesor")
    CursoEDto toEDto(Curso curso);
}
