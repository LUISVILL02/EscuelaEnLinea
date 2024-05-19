package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ProfesorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.ProfesorMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.ProfesorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProfesorImp implements ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    @Override
    public Optional<ProfesorEDto> findByNombreCompleto(String nombre, String apellido) {
        Optional<Profesor> profesor = profesorRepository.findByNombreAndApellido(nombre, apellido);
        if (profesor.isEmpty()){
            throw new EntityNoFoundException("No se encontro al profesor " + nombre + " " + apellido);
        }
        return profesor.map(profesorMapper::toEDto);
    }

    @Override
    public List<ProfesorEDto> findAll() {
        List<Profesor> profesors = profesorRepository.findAll();
        if (profesors.isEmpty()){
            throw new EntityNoFoundException("No se encontro a ningun profesor");
        }
        List<ProfesorEDto> profesorEDtos = null;
        profesorEDtos = profesors.stream().map(profesorMapper::toEDto).collect(Collectors.toList());
        return profesorEDtos;
    }

    @Override
    public Optional<ProfesorEDto> findById(Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if(profesor.isEmpty()){
            throw new EntityNoFoundException("No se encontro al profesor con id: " + id);
        }
        return profesor.map(profesorMapper::toEDto);
    }

    @Override
    public void deleteById(Long id) {
        boolean existProfesor = profesorRepository.existsById(id);
        if (existProfesor) profesorRepository.deleteById(id);
        else throw new EntityNoFoundException("No se encontro ningun profesor con id: " + id);
    }
}
