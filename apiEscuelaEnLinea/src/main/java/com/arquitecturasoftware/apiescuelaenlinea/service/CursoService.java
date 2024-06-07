package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CursoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CursoGDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    CursoEDto guardarCurso(CursoGDto cursoGDto);
    Page<CursoEDto> listarCursos();
    Optional<CursoEDto> buscarCurso(Long idCurso);
    void eliminarCurso(Long idCurso);
    Double promedioNotas(Long idCurso);
    Optional<CursoEDto> buscarCursoPorNombre(String nombre);
    Page<CursoEDto> listarCursosPorProfesor(Long id);
    List<CursoEDto> listarCursosPorProfesorId(Long id);
}
