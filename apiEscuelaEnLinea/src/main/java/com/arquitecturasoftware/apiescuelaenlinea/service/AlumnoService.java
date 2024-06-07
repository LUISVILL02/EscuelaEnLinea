package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AlumnoGDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AlumnoService {
    AlumnoEDto saveAlumno(AlumnoGDto alumno);
    Page<AlumnoEDto> getAlumnos(Integer start, Integer limit);
    AlumnoEDto getAlumnoById(Long id);
    void deleteAlumno(Long id);
    AlumnoEDto updateAlumno(AlumnoGDto alumno, Long id);
}
