package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import org.mapstruct.*;

@Mapper
public interface AcudienteMapper {
    AcudienteGDto toDto(Acudiente acudiente);
    @InheritInverseConfiguration
    Acudiente toAcudiente(AcudienteGDto acudienteDto);
}
