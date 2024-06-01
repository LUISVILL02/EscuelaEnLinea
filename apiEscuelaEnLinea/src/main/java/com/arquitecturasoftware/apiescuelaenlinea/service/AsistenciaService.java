package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsistenciaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asistencia;

import java.util.*;

public interface AsistenciaService {
    List<AsistenciaEDto> findAll();
    Optional<AsistenciaEDto> findById(long id);
    void save(AsistenciaGDto asistencia);
    void delete(AsistenciaEDto asistencia);
    AsistenciaEDto updateById(AsistenciaGDto asistenciaGDto);
}
