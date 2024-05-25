package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.exceptions.EntityNoFoundException;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Alumno;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AdministradorMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AdministradorRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdministradorImp implements AdministradorService {
    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;
    @Override
    public List<AdministradorEDto> findAll() {
        List<Administrador> administradores = administradorRepository.findAll();
        if (administradores.isEmpty()){
            throw new EntityNoFoundException("No se encontro ningun administrador");
        }
        return administradores.stream().map(administradorMapper::toEDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AdministradorEDto> findByNombreCompleto(String nombre, String apellido) {
        Optional<Administrador> administrador = administradorRepository.findByNombreAndApellido(nombre, apellido);
        if (administrador.isEmpty()){
            throw new EntityNoFoundException("No se encontro al administrador " + nombre + " " + apellido);
        }
        return administrador.map(administradorMapper::toEDto);
    }

    @Override
    public Optional<AdministradorEDto> findById(Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isEmpty()){
            throw new EntityNoFoundException("No se encontro a ningun administrador con id: " + id);
        }
        return administrador.map(administradorMapper::toEDto);
    }

    @Override
    public void deleteById(Long id) {
        boolean existAdmin = administradorRepository.existsById(id);
        if (existAdmin) administradorRepository.deleteById(id);
        else throw new EntityNoFoundException("No existe un administrador con id: " + id);
    }

    @Override
    public AdministradorEDto updateById(AdministradorGDto administrador, long id) {
        Optional<Administrador> admin = administradorRepository.findById(id);
        if(admin.isPresent()){
            return administradorMapper.toEDto(administradorRepository.save(administradorMapper.toAdministrador(administrador)));
        }
        Administrador adminUpdate = admin.get().updateAdmin(administradorMapper.toAdministrador(administrador));
        return administradorMapper.toEDto(administradorRepository.save(adminUpdate));
    }
}

