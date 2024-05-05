package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ProfesorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Profesor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface ProfesorMapper {
    ProfesorGDto toDto(Profesor profesor);
    @InheritInverseConfiguration
    Profesor toProfesor(ProfesorGDto profesorDto);
}
