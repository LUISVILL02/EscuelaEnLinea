package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignaturaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignaturaGDto;

import java.util.List;

public interface AsignaturaService {
    AsignaturaEDto save(AsignaturaGDto asignaturaGDto);
    AsignaturaEDto findById(Long id);
    Boolean delete(Long id);
    List<AsignaturaEDto> findAll();
}
