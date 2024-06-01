package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsistenciaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asistencia;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AsistenciaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AlumnoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsignacionRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsistenciaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CursoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AsistenciaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AsistenciaServiceImp implements AsistenciaService {
    private final AsistenciaRepository asistenciaRepository;
    private final AsistenciaMapper asistenciaMapper;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final AsignacionRepository asignacionRepository;

    @Override
    public List<AsistenciaEDto> findAll() {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        return asistencias.stream().map(asistenciaMapper::toEDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AsistenciaEDto> findById(long id) {
        return asistenciaRepository.findById(id).map(asistenciaMapper::toEDto);
    }

    @Override
    public AsistenciaEDto save(AsistenciaGDto asistencia) {
            boolean existAlumno = alumnoRepository
                    .existsById(asistencia.getIdAlumno().describeConstable()
                            .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado")));
            boolean existAsignacion = asignacionRepository.existsById(asistencia.getIdAsignacion()
                    .describeConstable().orElseThrow(() -> new EntityNotFoundException("Asignacion no encontrado")));
            return asistenciaMapper.toEDto(asistenciaRepository.save(asistenciaMapper.toAsistencia(asistencia)));
    }

    @Override
    public void delete(Long id) {
        asistenciaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Asignacion no encontrado"));
        asistenciaRepository.deleteById(id);
    }

    @Override
    public AsistenciaEDto updateById(AsistenciaGDto asistenciaGDto) {
        return null;
    }
}
