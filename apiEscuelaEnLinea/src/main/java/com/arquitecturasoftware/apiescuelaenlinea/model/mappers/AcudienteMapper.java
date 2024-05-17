package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AcudienteEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AcudienteGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Acudiente;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Role;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public interface AcudienteMapper{
    AcudienteGDto toDto(Acudiente acudiente);
    Acudiente toAcudiente(AcudienteGDto acudienteDto);
    AcudienteEDto toEDto(Acudiente acudiente);

}
