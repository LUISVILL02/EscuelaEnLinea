package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoCitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.EstadoCitaGDto;

import java.util.List;
import java.util.Optional;

public interface EstadoCitaService {
    EstadoCitaEDto save(EstadoCitaGDto estadoCitaGDto);
    Optional<EstadoCitaEDto> getEstadoCita(Long id);
    List<EstadoCitaEDto> findAll();
}
