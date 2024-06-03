package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignatura;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AsignacionMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsignacionRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsignaturaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CursoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ProfesorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AsignacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AsignacionServiceImpl implements AsignacionService {
    private final ProfesorRepository profesorRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final CursoRepository cursoRepository;
    private final AsignacionMapper asignacionMapper;
    private final AsignacionRepository asignacionRepository;
    @Override
    public AsignacionEDto hacerAsignacion(AsignacionGDto asignacionGDto) {
        Profesor profesor = profesorRepository.findById(asignacionGDto.getIdProfesor())
                .orElseThrow(() -> new EntityNoFoundException("Profesor no encontrado"));
        Curso curso = cursoRepository.findById(asignacionGDto.getIdCurso())
                .orElseThrow(() -> new EntityNoFoundException("Curso no encontrado"));
        Asignatura asignatura = asignaturaRepository.findById(asignacionGDto.getIdAsignatura())
                .orElseThrow(() -> new EntityNoFoundException("Asignatura no encontrada"));
        Asignacion asignacion = asignacionMapper.toAsignacion(asignacionGDto);
        asignacion.setProfesor(profesor);
        asignacion.setCurso(curso);
        asignacion.setAsignatura(asignatura);
        return asignacionMapper.toEDto(asignacionRepository.save(asignacion));
    }

    @Override
    public AsignacionEDto buscarAsignacion(Long idAsignacion) {
        Asignacion asignacion = asignacionRepository.findById(idAsignacion)
                .orElseThrow(() -> new EntityNoFoundException("No se encontro la asignacion con id: " + idAsignacion));
        return asignacionMapper.toEDto(asignacion);
    }

    @Override
    public Boolean eliminarAsignacion(Long idAsignacion) {
        if (asignacionRepository.existsById(idAsignacion)){
            asignacionRepository.deleteById(idAsignacion);
            return true;
        }
        return false;
    }


}
