package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.NotaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ObservacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Nota;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import lombok.AllArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    AlumnoGDto toDto(Alumno alumno);

    @Mappings({
            @Mapping(target = "curso.idCurso", source = "idCurso"),
            @Mapping(target = "acudiente.idUser", source = "idAcudiente"),
            @Mapping(target = "dirección", source = "dirección"),
            @Mapping(target = "identificación", source = "identificación"),
    })
    Alumno toAlumno(AlumnoGDto alumnoDto);

    @Mappings({
            @Mapping(source = "acudiente.nombre", target = "nombreAcudiente"),
            @Mapping(source = "acudiente.apellido", target = "apellidoAcudiente"),
            @Mapping(source = "curso.nombre", target = "nombreCurso"),
            @Mapping(source = "dirección", target = "dirección"),
            @Mapping(source = "identificación", target = "identificación"),
            @Mapping(source = "observaciones", target = "observaciones"),
    })
    AlumnoEDto toEDto(Alumno alumno);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    ObservacionEDto toObservacionEDto(Observacion observacion);

    @Mappings({
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    NotaEDto toNotaEDto(Nota nota);

}
