package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Curso;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.CursoMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CursoRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ProfesorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CursoServiceImp implements CursoService {
    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;
    private final CursoMapper cursoMapper;
    @Override
    public CursoEDto guardarCurso(CursoGDto cursoGDto) {
        Profesor profesor = profesorRepository.findById(cursoGDto.getIdProfesor())
                .orElseThrow(() -> new EntityNoFoundException("Profesor no encontrado"));
        Curso curso = cursoMapper.toCurso(cursoGDto);
        curso.setProfesor(profesor);
        profesor.getCursos().add(curso);
        if (Objects.isNull(curso.getAlumnos())){
            curso.setAlumnos(new ArrayList<>());
        }
        return cursoMapper.toEDto(cursoRepository.save(curso));
    }

    @Override
    public Page<CursoEDto> listarCursos() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<Curso> cursos = cursoRepository.findAll(pageable);
        return cursos.map(cursoMapper::toEDto);
    }

    @Override
    public Optional<CursoEDto> buscarCurso(Long idCurso) {
        return Optional.ofNullable(cursoRepository.findById(idCurso).map(cursoMapper::toEDto)
                .orElseThrow(() -> new EntityNoFoundException("Curso no encontrado con el id" + idCurso)));
    }

    @Override
    public void eliminarCurso(Long idCurso) {
        cursoRepository.findById(idCurso)
                .orElseThrow(() ->
                        new EntityNoFoundException("Error al eliminar el curso con id" + idCurso + " no encontrado"));
        cursoRepository.deleteById(idCurso);
    }

    @Override
    public Double promedioNotas(Long idCurso) {
        return cursoRepository.promedioNotas(idCurso);
    }

    @Override
    public Optional<CursoEDto> buscarCursoPorNombre(String nombre) {
        return Optional.ofNullable(cursoRepository.findByNombre(nombre).map(cursoMapper::toEDto)
                .orElseThrow(() -> new EntityNoFoundException("Curso no encontrado con el nombre" + nombre)));
    }

    @Override
    public Page<CursoEDto> listarCursosPorProfesor(Long id) {
        Pageable pageable = PageRequest.of(0, 20);
        Page<Curso> cursos = cursoRepository.findByProfesorId(id, pageable);
        return cursos.map(cursoMapper::toEDto);
    }

    @Override
    public List<CursoEDto> listarCursosPorProfesorId(Long id) {
        profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("Profesor no encontrado"));
        List<Curso> cursos = cursoRepository.findByCursoProfesorId(id);
        return cursos.stream().map(cursoMapper::toEDto).toList();
    }
}
