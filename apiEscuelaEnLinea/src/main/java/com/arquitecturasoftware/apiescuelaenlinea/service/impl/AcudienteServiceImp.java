package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AlumnoEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AcudienteMapper;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AlumnoMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AcudienteRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AcudienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AcudienteServiceImp implements AcudienteService {
    private final AcudienteRepository acudienteRepository;
    private final AcudienteMapper acudienteMapper;
    private final AlumnoMapper alumnoMapper;

    @Override
    public List<AcudienteEDto> findAll() {
    List<Acudiente> acudientes = acudienteRepository.findAll();
    if (acudientes.isEmpty()) throw new EntityNotFoundException("No se encontro el acudiente");
    return acudientes.stream().map(acudienteMapper::toEDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AcudienteEDto> findByNombreCompleto(String nombre, String apellido) {
        Optional<Acudiente> acudiente = acudienteRepository.findByNombreAndApellido(nombre, apellido);
        if (acudiente.isEmpty()) throw new EntityNotFoundException("No se encontro el acudiente");
        return acudiente.map(acudienteMapper::toEDto);
    }

    @Override
    public Optional<AcudienteEDto> findById(Long id) {
        Optional<Acudiente> acudiente = acudienteRepository.findById(id);
        if (acudiente.isEmpty()) throw new EntityNotFoundException("No se encontro el acudiente");
        return acudiente.map(acudienteMapper::toEDto);
    }

    @Override
    public void deleteById(Long id) {
        boolean existAcudiente = acudienteRepository.existsById(id);
        if (existAcudiente) acudienteRepository.deleteById(id);
        else throw new EntityNotFoundException("No existe el acudiente con id " + id);
    }

    @Override
    public List<AlumnoEDto> getAlumnosByAcudiente(Long id) {
        Optional<Acudiente> acudienteOptional = acudienteRepository.findById(id);
        if (acudienteOptional.isPresent()){
            List<Alumno> alumnos = acudienteOptional.get().getAlumnos();
            return alumnos.stream().map(alumnoMapper::toEDto).collect(Collectors.toList());
        }
        throw new EntityNotFoundException("No se encontro al acudiente con id " + id);
    }
}
