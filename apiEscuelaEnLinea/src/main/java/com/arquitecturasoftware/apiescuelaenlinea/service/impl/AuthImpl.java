package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AcudienteMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.AcudienteRepository;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.UsuarioRepository;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthImpl implements AuthService{

    private final UsuarioRepository usuarioRepository;
    private final AcudienteRepository acudienteRepository;
    private final AcudienteMapper acudienteMapper;
    @Override
    public ResponseJwt login(String correo, String contraseña) {
        return null;
    }

    @Override
    public String registerAcudiente(AcudienteGDto acudienteGDto) {
        if (usuarioRepository.existsByIdentificacion(acudienteGDto.getIdentificacion()) || usuarioRepository.existsByCorreo(acudienteGDto.getCorreo()))
            return "El usuario ya existe";

        Set<Role> roles = acudienteGDto.getRoles().stream()
                .map(role -> Role.builder()
                        .name(ERole.valueOf(role))
                        .build()
                ).collect(Collectors.toSet());
        Usuario usuario = Usuario.builder()
                .nombre(acudienteGDto.getNombre())
                .apellido(acudienteGDto.getApellido())
                .identificacion(acudienteGDto.getIdentificacion())
                .correo(acudienteGDto.getCorreo())
                .telefono(acudienteGDto.getTelefono())
                .contraseña(acudienteGDto.getContraseña())
                .build();

        usuario.setRoles(roles);
        Usuario userSave =  usuarioRepository.save(usuario);
        /*Acudiente acudiente = new Acudiente(acudienteGDto.getNombre(), acudienteGDto.getApellido(),
                acudienteGDto.getIdentificacion(), acudienteGDto.getCorreo(), acudienteGDto.getTelefono(),
                acudienteGDto.getContraseña(), acudienteGDto.getDireccion());*/
        Acudiente acudiente = acudienteMapper.toAcudiente(acudienteGDto);
        acudiente.setIdUser(userSave.getIdUser());
        acudiente.setRoles(roles);
        acudienteRepository.save(acudiente);
        return "Acudiente registrado con éxito";
    }

    @Override
    public String registerProfesor(ProfesorGDto profesorGDto) {
        return null;
    }

    @Override
    public String registerAdministrador(AdministradorGDto administradorGDto) {
        return null;
    }

}
