package com.arquitecturasoftware.apiescuelaenlinea.model.mappers.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AcudienteMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AcudienteMapperImpl implements AcudienteMapper {
    @Override
    public AcudienteGDto toDto(Acudiente acudiente) {
        AcudienteGDto acudienteDto = new AcudienteGDto();
        acudienteDto.setNombre(acudiente.getNombre());
        acudienteDto.setApellido(acudiente.getApellido());
        acudienteDto.setCorreo(acudiente.getCorreo());
        acudienteDto.setIdentificacion(acudiente.getIdentificacion());
        acudienteDto.setContraseña(acudiente.getContraseña());
        acudienteDto.setTelefono(acudiente.getTelefono());
        acudienteDto.setRoles(acudiente.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        acudienteDto.setDireccion(acudiente.getDireccion());
        return acudienteDto;
    }

    @Override
    public Acudiente toAcudiente(AcudienteGDto acudienteDto) {
        Acudiente acudiente = new Acudiente();
        acudiente.setNombre(acudienteDto.getNombre());
        acudiente.setApellido(acudienteDto.getApellido());
        acudiente.setCorreo(acudienteDto.getCorreo());
        acudiente.setIdentificacion(acudienteDto.getIdentificacion());
        acudiente.setContraseña(acudienteDto.getContraseña());
        acudiente.setTelefono(acudienteDto.getTelefono());
        acudiente.setDireccion(acudienteDto.getDireccion());
        acudiente.setRoles(acudienteDto.getRoles().stream().map(role -> {
            Role r = new Role();
            r.setName(Enum.valueOf(ERole.class, role));
            return r;
        }).collect(Collectors.toSet()));
        return acudiente;
    }

    @Override
    public AcudienteEDto toEDto(Acudiente acudiente) {
        AcudienteEDto acudienteDto = new AcudienteEDto();
        acudienteDto.setIdUser(acudiente.getIdUser());
        acudienteDto.setNombre(acudiente.getNombre());
        acudienteDto.setApellido(acudiente.getApellido());
        acudienteDto.setCorreo(acudiente.getCorreo());
        acudienteDto.setIdentificador(acudiente.getIdentificacion());
        acudienteDto.setTelefono(acudiente.getTelefono());
        acudienteDto.setDireccion(acudiente.getDireccion());
        acudienteDto.setRoles(acudiente.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return acudienteDto;
    }
}
