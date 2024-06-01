package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoAsistenciaEDto;

import java.util.List;
import java.util.Optional;

public interface EstadoAsistenciaService {
    List<EstadoAsistenciaEDto> findAll();
    Optional<EstadoAsistenciaEDto> findById(Long id);
}
