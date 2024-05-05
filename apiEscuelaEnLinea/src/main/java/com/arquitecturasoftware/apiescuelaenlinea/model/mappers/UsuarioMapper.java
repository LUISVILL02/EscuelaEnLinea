package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.UsuarioGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import org.mapstruct.*;


@Mapper
public interface UsuarioMapper {

    UsuarioGDto toDto(Usuario usuario);
    @InheritInverseConfiguration
    Usuario toUsuario(UsuarioGDto usuarioDto);
}
