package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoCitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.EstadoCitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoCita;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.EstadoCitaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.EstadoCitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.EstadoCitaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EstadoCitaImpl implements EstadoCitaService {

    private final EstadoCitaRepository estadoCitaRepository;
    private final EstadoCitaMapper estadoCitaMapper;

    @Override
    public EstadoCitaEDto save(EstadoCitaGDto estadoCitaGDto) {
        return estadoCitaMapper.toEDto(estadoCitaRepository.save(estadoCitaMapper.toEstadoCita(estadoCitaGDto)));
    }

    @Override
    public Optional<EstadoCitaEDto> getEstadoCita(Long id) {
        EstadoCita estadoCita = estadoCitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro el estado de la cita"));
        return Optional.ofNullable(estadoCitaMapper.toEDto(estadoCita));
    }

    @Override
    public List<EstadoCitaEDto> findAll() {
        return estadoCitaRepository.findAll().stream().map(estadoCitaMapper::toEDto).toList();
    }
}
