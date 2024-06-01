package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignaturaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignaturaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignatura;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AsignaturaMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AsignaturaRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;
    private final AsignaturaMapper asignaturaMapper;
    @Override
    public AsignaturaEDto save(AsignaturaGDto asignaturaGDto) {
        Asignatura asignatura = asignaturaRepository.save(asignaturaMapper.toAsignatura(asignaturaGDto));
        if (isNull(asignatura.getAsignaciones())) asignatura.setAsignaciones(new ArrayList<>());
        return asignaturaMapper.toEDto(asignatura);
    }

    @Override
    public AsignaturaEDto findById(Long id) {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("No se encontro la asignatura con id: " + id));
        return asignaturaMapper.toEDto(asignatura);
    }

    @Override
    public Boolean delete(Long id) {
        asignaturaRepository.findById(id)
                .orElseThrow(() -> new EntityNoFoundException("No se pudo borra porque no existe: " + id));
        asignaturaRepository.deleteById(id);
        return true;
    }

    @Override
    public List<AsignaturaEDto> findAll() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        if (asignaturas.isEmpty()) throw new EntityNoFoundException("No se encontraron asignaturas");
        return asignaturas.stream().map(asignaturaMapper::toEDto).toList();
    }
}
