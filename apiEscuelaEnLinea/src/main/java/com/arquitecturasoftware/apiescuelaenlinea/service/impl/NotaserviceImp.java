package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.NotaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.NotaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Nota;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.NotaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.*;
import com.arquitecturasoftware.apiescuelaenlinea.service.NotaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class NotaserviceImp implements NotaService {
    private final NotaRepository notaRepository;
    private final AlumnoRepository alumnoRepository;
    private final AsignacionRepository asignacionRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final NotaMapper notaMapper;
    @Override
    public NotaEDto save(NotaGDto notaGDto) {
        alumnoRepository.findById(notaGDto.getIdAlumno())
                .orElseThrow(() -> new EntityNoFoundException("No se encontro el alumno con el id: "+ notaGDto.getIdAlumno()));
        Asignacion asignacion = asignacionRepository.findById(notaGDto.getIdAsignacion())
                .orElseThrow(() -> new EntityNoFoundException("No se encontro la asignacion con el id: "+ notaGDto.getIdAsignacion()));
        Curso curso = cursoRepository.findById(asignacion.getCurso().getIdCurso())
                .orElseThrow(() -> new EntityNoFoundException("No se encontro el curso con el id: "+ asignacion.getCurso().getIdCurso()));
        curso.getAlumnos().stream().filter(alumno -> alumno.getIdAlumno().equals(notaGDto.getIdAlumno()))
                .findFirst().orElseThrow(() -> new EntityNoFoundException("El alumno no esta en el curso"));
        return notaMapper.toEDto(notaRepository.save(notaMapper.toNota(notaGDto)));
    }

    @Override
    public NotaEDto findById(Long id) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("No se encontro la nota con el id: "+ id));
        return notaMapper.toEDto(nota);
    }

    @Override
    public NotaEDto findByNombreAndIdAlumno(String nombre, Long idAlumno) {
        alumnoRepository.findById(idAlumno)
                .orElseThrow(() -> new EntityNoFoundException("No se encontro el alumno con el id: "+ idAlumno));
        if (nombre.isEmpty()) throw new EntityNoFoundException("No hay nota para la activdad: "+ nombre);
        Nota nota = notaRepository.findByNombreActividadAndAlumno_IdAlumno(nombre, idAlumno);
        if(isNull(nota)) throw new EntityNoFoundException("No se encontro la nota para la actividad: "+ nombre);
        return notaMapper.toEDto(nota);
    }

    @Override
    public NotaEDto update(Float nota, Long idNota) {
        Nota notaEntity = notaRepository.findById(idNota)
                .orElseThrow(() -> new EntityNoFoundException("No se encontro la nota con el id: "+ idNota));
        notaEntity.setNota(nota);
        return notaMapper.toEDto(notaRepository.save(notaEntity));
    }
}
