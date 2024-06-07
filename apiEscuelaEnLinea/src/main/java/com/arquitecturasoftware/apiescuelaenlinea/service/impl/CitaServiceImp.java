package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Cita;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.CitaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AcudienteRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.CitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.EstadoCitaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ProfesorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.CitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CitaServiceImp implements CitaService {
    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;
    private final ProfesorRepository profesorRepository;
    private final AcudienteRepository acudienteRepository;
    private final EstadoCitaRepository estadoCitaRepository;


    @Override
    public List<CitaEDto> findAll() {
        return citaRepository.findAll().stream().map(citaMapper::toEDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CitaEDto> findById(Long id) {
        if (citaRepository.existsById(id)) {
            return Optional.ofNullable(citaMapper.toEDto(citaRepository.getById(id)));
        }
        return Optional.empty();
    }

    @Override
    public List<CitaEDto> findCitasByProfesor(Long idProfesor) {
        if (profesorRepository.existsById(idProfesor)){
            return citaRepository.getCitasByProfesor_IdUser(idProfesor).stream().map(citaMapper::toEDto).toList();
        }
        return Collections.emptyList();
    }

    @Override
    public List<CitaEDto> findCitasByAcudiente(Long idAcudiente) {
        if (acudienteRepository.existsById(idAcudiente)){
            return citaRepository.getCitasByAcudiente_IdUser(idAcudiente).stream().map(citaMapper::toEDto).toList();
        }
        return Collections.emptyList();
    }

    @Override
    public CitaEDto save(CitaGDto citaGDto) {
        Cita cita = citaMapper.toCita(citaGDto);
        return citaMapper.toEDto(citaRepository.save(cita));
    }

    @Override
    public List<CitaEDto> findCitasByEstadoCita(Long idEstadoCita) {
        if (estadoCitaRepository.existsById(idEstadoCita)){
            return citaRepository.getCitasByEstadoCita_IdEstadoCita(idEstadoCita).stream().map(citaMapper::toEDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
