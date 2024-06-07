package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AlumnoMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AcudienteRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AlumnoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CursoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AlumnoServiceImp implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;
    private final AlumnoMapper alumnoMapper;
    private final AcudienteRepository acudienteRepository;

    @Override
    public AlumnoEDto saveAlumno(AlumnoGDto alumnoGdto) {
        Curso curso = cursoRepository.findById(alumnoGdto.getIdCurso())
                .orElseThrow(() -> new EntityNoFoundException("Curso no encontrado"));
        Acudiente acudiente = acudienteRepository.findById(alumnoGdto.getIdAcudiente())
                .orElseThrow(() -> new EntityNoFoundException("Acudiente no encontrado"));
        Alumno alumno = alumnoMapper.toAlumno(alumnoGdto);
        alumno.setAcudiente(acudiente);
        curso.getAlumnos().add(alumno);
        alumno.setCurso(curso);
        return alumnoMapper.toEDto(alumnoRepository.save(alumno));
    }

    @Override
    public Page<AlumnoEDto> getAlumnos(Integer start, Integer limit) {
        Pageable pageable = PageRequest.of(start, limit);
        Page<Alumno> alumnos = alumnoRepository.findAll(pageable);
        return alumnos.map(alumnoMapper::toEDto);
    }

    @Override
    public AlumnoEDto getAlumnoById(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("Alumno no encontrado"));
        return alumnoMapper.toEDto(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("Ocurrio un error en  el servidor y no se pudo borrar"));
        alumnoRepository.deleteById(id);
    }

    @Override
    public AlumnoEDto updateAlumno(AlumnoGDto alumno, Long id) {
        Optional<Alumno> alumno1 = alumnoRepository.findById(id);
        if(alumno1.isEmpty()){
            return alumnoMapper.toEDto(alumnoRepository.save(alumnoMapper.toAlumno(alumno)));
        }
        Alumno alumnoUpdate = alumno1.get().updateAlumno(alumnoMapper.toAlumno(alumno));
        return alumnoMapper.toEDto(alumnoRepository.save(alumnoUpdate));
    }

}
