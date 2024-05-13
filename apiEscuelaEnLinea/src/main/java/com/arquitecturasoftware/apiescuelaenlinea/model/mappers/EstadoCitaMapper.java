package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.EstadoCitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.EstadoCitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoCita;
import org.mapstruct.*;

@Mapper
public interface EstadoCitaMapper {

    EstadoCitaGDto toDto(EstadoCita estadoCita);
    @InheritInverseConfiguration
    EstadoCita toEstadoCita(EstadoCitaGDto estadoCitaDto);
    EstadoCitaEDto toEDto(EstadoCita estadoCita);
}
