package com.arquitecturasoftware.apiescuelaenlinea.service.impl;

import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.Login;
import com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth.ResponseJwt;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.*;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AcudienteMapper;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.AdministradorMapper;
import com.arquitecturasoftware.apiescuelaenlinea.model.mappers.ProfesorMapper;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.*;
import com.arquitecturasoftware.apiescuelaenlinea.security.jwt.JwtUtils;
import com.arquitecturasoftware.apiescuelaenlinea.service.AuthService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthImpl implements AuthService{

    private final UsuarioRepository usuarioRepository;
    private final AcudienteRepository acudienteRepository;
    private final RoleRepository roleRepository;
    private final AcudienteMapper acudienteMapper;
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;
    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Override
    public ResponseJwt login(Login login) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                login.getCorreo(), login.getContraseña()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        Usuario usuario = usuarioRepository.findByCorreo(login.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        String jwt = jwtUtils.getToken(usuario);
        return ResponseJwt.builder()
                .email(usuario.getCorreo())
                .token(jwt)
                .roles(usuario.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList()))
                .id(usuario.getIdUser())
                .identificacion(usuario.getIdentificacion())
                .type("Bearer")
                .build();
    }

    @Override
    public String registerAcudiente(AcudienteGDto acudienteGDto) {
        if (usuarioRepository.existsByIdentificacion(acudienteGDto.getIdentificacion()) || usuarioRepository.existsByCorreo(acudienteGDto.getCorreo()))
            throw new RuntimeException("El acudiente ya existe");

        Set<Role> roles = acudienteGDto.getRoles().stream()
                .map(roleName -> {
            ERole eRole = ERole.valueOf(roleName);
                    return roleRepository.findByName(eRole)
                            .orElseGet(() -> Role.builder().name(eRole).build());
        })
        .collect(Collectors.toSet());
        Acudiente acudiente = acudienteMapper.toAcudiente(acudienteGDto);
        acudiente.setRoles(roles);
        acudiente.setContraseña(encoder.encode(acudiente.getContraseña()));
        acudienteRepository.save(acudiente);
        return "Acudiente registrado con éxito";
    }

    @Override
    public String registerProfesor(ProfesorGDto profesorGDto) {
        if (usuarioRepository.existsByIdentificacion(profesorGDto.getIdentificacion())
                || usuarioRepository.existsByCorreo(profesorGDto.getCorreo()))
            throw new RuntimeException("El profesor ya existe");
        Set<Role> roles = profesorGDto.getRoles().stream()
                .map(roleName -> {
                    ERole eRole = ERole.valueOf(roleName);
                    return roleRepository.findByName(eRole)
                            .orElseGet(() -> Role.builder().name(eRole).build());
                })
                .collect(Collectors.toSet());
        Profesor profesor = profesorMapper.toProfesor(profesorGDto);
        profesor.setRoles(roles);
        profesor.setContraseña(encoder.encode(profesor.getContraseña()));
        profesorRepository.save(profesor);
        return "Profesor registrado con éxito";
    }

    @Override
    public String registerAdministrador(AdministradorGDto administradorGDto) {
        if (usuarioRepository.existsByIdentificacion(administradorGDto.getIdentificacion())
                || usuarioRepository.existsByCorreo(administradorGDto.getCorreo()))
            throw new RuntimeException("El administrador ya existe");
        Set<Role> roles = administradorGDto.getRoles().stream()
                .map(roleName -> {
                    ERole eRole = ERole.valueOf(roleName);
                    return roleRepository.findByName(eRole)
                            .orElseGet(() -> Role.builder().name(eRole).build());
                })
                .collect(Collectors.toSet());
        Administrador administrador = administradorMapper.toAdministrador(administradorGDto);
        administrador.setRoles(roles);
        administrador.setContraseña(encoder.encode(administrador.getContraseña()));
        administradorRepository.save(administrador);
        return "Administrador registrado con éxito";
    }

}
