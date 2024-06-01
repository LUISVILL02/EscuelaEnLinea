package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignaturaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignaturaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignatura;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AsignaturaMapper {
    AsignaturaGDto toDto(Asignatura asignatura);
    @InheritInverseConfiguration
    Asignatura toAsignatura(AsignaturaGDto asignaturaDto);
    AsignaturaEDto toEDto(Asignatura asignatura);
}
