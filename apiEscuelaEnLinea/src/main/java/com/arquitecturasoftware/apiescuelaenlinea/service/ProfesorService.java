package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ProfesorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;

import java.util.*;

public interface ProfesorService {
    Optional<ProfesorEDto> findByNombreCompleto(String name, String apellido);
    List<ProfesorEDto> findAll();
    Optional<ProfesorEDto> findById(Long id);

    void deleteById(Long id);
}
