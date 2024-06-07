package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ObservacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ObservacionGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignacion;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Observacion;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.ObservacionMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AlumnoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsignacionRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ObservacionRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ProfesorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.ObservacionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ObservacionServiceImp implements ObservacionService {

    private final ObservacionRepository observacionRepository;
    private final AlumnoRepository alumnoRepository;
    private final AsignacionRepository asignacionRepository;
    private final ProfesorRepository profesorRepository;
    private final ObservacionMapper observacionMapper;
    @Override
    public ObservacionEDto save(ObservacionGDto observacionGDto) {
        profesorRepository.findById(observacionGDto.getIdProfesor())
                .orElseThrow(() -> new EntityNoFoundException("Profesor no encontrado con el id: " + observacionGDto.getIdProfesor()));
        alumnoRepository.findById(observacionGDto.getIdAlumno())
                .orElseThrow(() -> new EntityNoFoundException("Alumno no encontrado con el id: " + observacionGDto.getIdAlumno()));
        Asignacion asignacion = asignacionRepository.findById(observacionGDto.getIdAsignacion())
                .orElseThrow(() -> new EntityNoFoundException("Asignacion no encontrada con el id: " + observacionGDto.getIdAsignacion()));
        asignacion.getCurso().getAlumnos().stream()
                .filter(alumno -> alumno.getIdAlumno().equals(observacionGDto.getIdAlumno()))
                .findFirst()
                .orElseThrow(() -> new EntityNoFoundException("El alumno no pertece al curso asignado"));
        if(!Objects.equals(asignacion.getProfesor().getIdUser(), observacionGDto.getIdProfesor())){
            throw new EntityNoFoundException("El profesor no es el asignado a la asignación");
        }
        Observacion observacion = observacionMapper.toObservacion(observacionGDto);
        observacion.setFecha(LocalDate.now());
        return observacionMapper.toEDto(observacionRepository.save(observacion));
    }

    @Override
    public ObservacionEDto findById(Long id) {
        Observacion observacion = observacionRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("Observacion no encontrada con el id: " + id));
        return observacionMapper.toEDto(observacion);
    }

    @Override
    public ObservacionEDto update(Long id, String descripcion) {
        Observacion observacion = observacionRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("Observacion no encontrada con el id: " + id));
        observacion.setDescripcion(descripcion);
        return observacionMapper.toEDto(observacionRepository.save(observacion));
    }

    @Override
    public void delete(Long id) {
        if(!observacionRepository.existsById(id)){
            throw new EntityNoFoundException("Observacion no encontrada con el id: " + id);
        }
        observacionRepository.deleteById(id);
    }

    @Override
    public Page<ObservacionEDto> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Observacion> observaciones = observacionRepository.findAll(pageable);
        return observaciones.map(observacionMapper::toEDto);
    }
}
