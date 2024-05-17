package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public interface AdministradorMapper {

    AdministradorGDto toDto(Administrador administrador);
    Administrador toAdministrador(AdministradorGDto administradorDto);
    AdministradorEDto toEDto(Administrador administrador);

}
