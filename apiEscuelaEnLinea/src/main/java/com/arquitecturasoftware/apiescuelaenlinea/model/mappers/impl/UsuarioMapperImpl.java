package com.arquitecturasoftware.apiescuelaenlinea.model.mappers.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.UsuarioEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.UsuarioGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.UsuarioMapper;

import java.util.stream.Collectors;

public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public UsuarioGDto toDto(Usuario usuario) {
        UsuarioGDto usuarioDto = new UsuarioGDto();
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setIdentificacion(usuario.getIdentificacion());
        usuarioDto.setContraseña(usuario.getContraseña());
        usuarioDto.setTelefono(usuario.getTelefono());
        usuarioDto.setRoles(usuario.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return usuarioDto;
    }

    @Override
    public Usuario toUsuario(UsuarioGDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setIdentificacion(usuarioDto.getIdentificacion());
        usuario.setContraseña(usuarioDto.getContraseña());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setRoles(usuarioDto.getRoles().stream().map(role -> {
            Role r = new Role();
            r.setName(Enum.valueOf(ERole.class, role));
            return r;
        }).collect(Collectors.toSet()));
        return usuario;
    }

    @Override
    public UsuarioEDto toEDto(Usuario usuario) {
        UsuarioEDto usuarioDto = new UsuarioEDto();
        usuarioDto.setIdUser(usuario.getIdUser());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setApellido(usuario.getApellido());
        usuarioDto.setCorreo(usuario.getCorreo());
        usuarioDto.setIdentificador(usuario.getIdentificacion());
        usuarioDto.setTelefono(usuario.getTelefono());
        usuarioDto.setRoles(usuario.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
        return usuarioDto;
    }
}
