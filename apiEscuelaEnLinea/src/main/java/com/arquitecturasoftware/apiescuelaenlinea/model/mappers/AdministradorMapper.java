package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;
import org.mapstruct.*;

@Mapper
public interface AdministradorMapper {
    AdministradorGDto toDto(Administrador administrador);
    @InheritInverseConfiguration
    Administrador toAdministrador(AdministradorGDto administradorDto);
    AdministradorEDto toEDto(Administrador administrador);
}
