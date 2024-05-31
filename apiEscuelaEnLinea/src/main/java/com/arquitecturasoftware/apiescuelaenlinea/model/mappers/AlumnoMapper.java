package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    // Removed mappings for idCurso and idAcudiente
    AlumnoGDto toDto(Alumno alumno);

    @Mappings({
            @Mapping(target = "curso.idCurso", source = "idCurso"),
            @Mapping(target = "acudiente.idUser", source = "idAcudiente")
    })
    Alumno toAlumno(AlumnoGDto alumnoDto);

    @Mappings({
            @Mapping(source = "acudiente.nombre", target = "nombreAcudiente"),
            @Mapping(source = "acudiente.apellido", target = "apellidoAcudiente"),
            @Mapping(source = "curso.nombre", target = "nombreCurso")
    })
    AlumnoEDto toEDto(Alumno alumno);
}
