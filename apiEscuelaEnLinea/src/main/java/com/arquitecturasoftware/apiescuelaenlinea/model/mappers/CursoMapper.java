package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ObservacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(source = "profesor.idUser", target = "idProfesor")
    CursoGDto toDto(Curso curso);
    @InheritInverseConfiguration
    Curso toCurso(CursoGDto cursoDto);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "asignaciones", target = "asignaciones"),
            @Mapping(source = "alumnos", target = "alumnos")
    })
    CursoEDto toEDto(Curso curso);

    @Mappings({
            @Mapping(source = "acudiente.nombre", target = "nombreAcudiente"),
            @Mapping(source = "acudiente.apellido", target = "apellidoAcudiente"),
            @Mapping(source = "curso.nombre", target = "nombreCurso"),
            @Mapping(source = "dirección", target = "dirección"),
            @Mapping(source = "identificación", target = "identificación"),
            @Mapping(source = "observaciones", target = "observaciones"),
    })
    AlumnoEDto toAlumnoEDto(Alumno alumno);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "alumno.nombre", target = "nombreAlumno"),
            @Mapping(source = "alumno.apellido", target = "apellidoAlumno"),
            @Mapping(source = "asignacion.idAsignacion", target = "idAsignacion")
    })
    ObservacionEDto toObservacionEDto(Observacion observacion);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "asignatura.nombre", target = "nombreAsignatura"),
            @Mapping(source = "curso.nombre", target = "nombreCurso")
    })
    AsignacionEDto toAsignacionEDto(Asignacion asignacion);
}
