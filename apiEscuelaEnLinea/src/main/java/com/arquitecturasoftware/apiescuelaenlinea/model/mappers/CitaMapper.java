package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.CitaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.CitaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Cita;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    @Mappings({
            @Mapping(source = "profesor.idUser", target = "idProfesor"),
            @Mapping(source = "acudiente.idUser", target = "idAcudiente"),
            })
    CitaGDto toDto(Cita cita);
    @InheritInverseConfiguration
    Cita toCita(CitaGDto citaDto);

    @Mappings({
            @Mapping(source = "profesor.nombre", target = "nombreProfesor"),
            @Mapping(source = "profesor.apellido", target = "apellidoProfesor"),
            @Mapping(source = "acudiente.nombre", target = "nombreAcudiente"),
            @Mapping(source = "acudiente.apellido", target = "apellidoAcudiente"),
            @Mapping(source = "estadoCita.nombre", target = "estadoCita")
    })
    CitaEDto toEDto(Cita cita);
}
