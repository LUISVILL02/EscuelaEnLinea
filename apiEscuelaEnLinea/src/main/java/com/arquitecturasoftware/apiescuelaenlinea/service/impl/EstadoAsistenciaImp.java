package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoAsistenciaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoAsistencia;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.EstadoAsistenciaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.EstadoAsistenciaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.EstadoAsistenciaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstadoAsistenciaImp implements EstadoAsistenciaService {

    private final EstadoAsistenciaMapper estadoAsistenciaMapper;
    private final EstadoAsistenciaRepository estadoAsistenciaRepository;

    @Override
    public List<EstadoAsistenciaEDto> findAll() {
        List<EstadoAsistencia> estadoAsistencias = estadoAsistenciaRepository.findAll();
        if (estadoAsistencias.isEmpty()){
            throw new EntityNotFoundException("No se encontro ningun estado asistencia");
        }
        return estadoAsistencias.stream().map(estadoAsistenciaMapper::toEDto).collect(Collectors.toList());
    }

    @Override
    public Optional<EstadoAsistenciaEDto> findById(Long id) {
        Optional<EstadoAsistencia> estadoAsistencia = estadoAsistenciaRepository.findById(id);
        if (estadoAsistencia.isPresent()){
            return Optional.of(estadoAsistenciaMapper.toEDto(estadoAsistencia.get()));
        }
        throw new EntityNotFoundException("No se encontro el estado por id " + id);
    }
}
