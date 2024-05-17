package com.arquitecturasoftware.apiescuelaenlinea.model.mappers.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ProfesorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.ProfesorMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfesorMapperImpl implements ProfesorMapper {
    @Override
    public ProfesorGDto toDto(Profesor profesor) {
        ProfesorGDto profesorDto = new ProfesorGDto();
        profesorDto.setNombre(profesor.getNombre());
        profesorDto.setApellido(profesor.getApellido());
        profesorDto.setCorreo(profesor.getCorreo());
        profesorDto.setIdentificacion(profesor.getIdentificacion());
        profesorDto.setContraseña(profesor.getContraseña());
        profesorDto.setTelefono(profesor.getTelefono());
        profesorDto.setDireccion(profesor.getDireccion());
        profesorDto.setFechaNacimiento(profesor.getFechaNacimiento());
        profesorDto.setRoles(profesor.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return profesorDto;
    }

    @Override
    public Profesor toProfesor(ProfesorGDto profesorDto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDto.getNombre());
        profesor.setApellido(profesorDto.getApellido());
        profesor.setCorreo(profesorDto.getCorreo());
        profesor.setIdentificacion(profesorDto.getIdentificacion());
        profesor.setContraseña(profesorDto.getContraseña());
        profesor.setTelefono(profesorDto.getTelefono());
        profesor.setDireccion(profesorDto.getDireccion());
        profesor.setFechaNacimiento(profesorDto.getFechaNacimiento());
        profesor.setRoles(profesorDto.getRoles().stream().map(role -> {
            Role r = new Role();
            r.setName(Enum.valueOf(ERole.class, role));
            return r;
        }).collect(Collectors.toSet()));
        return profesor;
    }

    @Override
    public ProfesorEDto toEDto(Profesor profesor) {
        ProfesorEDto profesorDto = new ProfesorEDto();
        profesorDto.setIdUser(profesor.getIdUser());
        profesorDto.setNombre(profesor.getNombre());
        profesorDto.setApellido(profesor.getApellido());
        profesorDto.setCorreo(profesor.getCorreo());
        profesorDto.setIdentificador(profesor.getIdentificacion());
        profesorDto.setTelefono(profesor.getTelefono());
        profesorDto.setDireccion(profesor.getDireccion());
        profesorDto.setFechaNacimiento(profesor.getFechaNacimiento());
        profesorDto.setRoles(profesor.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return profesorDto;
    }
}
