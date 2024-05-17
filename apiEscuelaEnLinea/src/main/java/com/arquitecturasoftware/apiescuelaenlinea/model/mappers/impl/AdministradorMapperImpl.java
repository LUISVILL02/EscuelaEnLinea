package com.arquitecturasoftware.apiescuelaenlinea.model.mappers.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AdministradorMapper;

import java.util.stream.Collectors;

public class AdministradorMapperImpl implements AdministradorMapper {
    @Override
    public AdministradorGDto toDto(Administrador administrador) {
        AdministradorGDto administradorGDto = new AdministradorGDto();
        administradorGDto.setNombre(administrador.getNombre());
        administradorGDto.setApellido(administrador.getApellido());
        administradorGDto.setCorreo(administrador.getCorreo());
        administradorGDto.setIdentificacion(administrador.getIdentificacion());
        administradorGDto.setContraseña(administrador.getContraseña());
        administradorGDto.setTelefono(administrador.getTelefono());
        administradorGDto.setRoles(administrador.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return administradorGDto;
    }

    @Override
    public Administrador toAdministrador(AdministradorGDto administradorDto) {
        Administrador administrador = new Administrador();
        administrador.setNombre(administradorDto.getNombre());
        administrador.setApellido(administradorDto.getApellido());
        administrador.setCorreo(administradorDto.getCorreo());
        administrador.setIdentificacion(administradorDto.getIdentificacion());
        administrador.setContraseña(administradorDto.getContraseña());
        administrador.setTelefono(administradorDto.getTelefono());
        administrador.setRoles(administradorDto.getRoles().stream().map(role -> {
            Role r = new Role();
            r.setName(Enum.valueOf(ERole.class, role));
            return r;
        }).collect(Collectors.toSet()));
        return administrador;
    }

    @Override
    public AdministradorEDto toEDto(Administrador administrador) {
        AdministradorEDto administradorEDto = new AdministradorEDto();
        administradorEDto.setIdUser(administrador.getIdUser());
        administradorEDto.setNombre(administrador.getNombre());
        administradorEDto.setApellido(administrador.getApellido());
        administradorEDto.setCorreo(administrador.getCorreo());
        administradorEDto.setIdentificador(administrador.getIdentificacion());
        administradorEDto.setTelefono(administrador.getTelefono());
        administradorEDto.setRoles(administrador.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return null;
    }
}
