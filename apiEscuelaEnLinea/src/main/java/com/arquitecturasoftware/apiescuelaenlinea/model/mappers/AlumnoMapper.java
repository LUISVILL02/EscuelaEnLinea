package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import org.mapstruct.*;

@Mapper
public interface AlumnoMapper {

    @Mappings({
            @Mapping(source = "acudiente.idAcudiente", target = "idAcudiente"),
            @Mapping(source = "curso.idCurso", target = "idCurso"),
    })
    AlumnoGDto toDto(Alumno alumno);
    @InheritInverseConfiguration
    Alumno toAlumno(AlumnoGDto alumnoDto);

    @Mappings({
            @Mapping(source = "acudiente.nombre", target = "nombreAcudiente"),
            @Mapping(source = "curso.nombre", target = "nombreCurso")
    })
    AlumnoEDto toEDto(Alumno alumno);
}
