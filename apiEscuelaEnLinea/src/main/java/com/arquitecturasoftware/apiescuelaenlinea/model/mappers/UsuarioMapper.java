package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.UsuarioEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.UsuarioGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public interface UsuarioMapper {
    UsuarioGDto toDto(Usuario usuario);
    Usuario toUsuario(UsuarioGDto usuarioDto);
    UsuarioEDto toEDto(Usuario usuario);

}
