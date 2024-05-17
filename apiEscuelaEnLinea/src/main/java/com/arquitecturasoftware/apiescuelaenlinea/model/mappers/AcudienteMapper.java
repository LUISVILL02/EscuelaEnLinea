package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AcudienteMapper {
    AcudienteGDto toDto(Acudiente acudiente);
    @InheritInverseConfiguration
    Acudiente toAcudiente(AcudienteGDto acudienteDto);
    AcudienteEDto toEDto(Acudiente acudiente);
}
