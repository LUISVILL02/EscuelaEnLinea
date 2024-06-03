package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;

import java.util.List;
import java.util.Optional;

public interface AcudienteService {
    List<AcudienteEDto> findAll();
    Optional<AcudienteEDto> findByNombreCompleto(String nombre, String apellido);
    Optional<AcudienteEDto> findById(Long id);
    AcudienteEDto findByIdentifiicacion(String identificacion);
    void deleteById(Long id);
    List<AlumnoEDto> getAlumnosByAcudiente(Long id);
}
