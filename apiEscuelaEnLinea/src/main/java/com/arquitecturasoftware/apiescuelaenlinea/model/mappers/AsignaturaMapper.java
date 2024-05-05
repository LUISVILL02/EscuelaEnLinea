package com.arquitecturasoftware.apiescuelaenlinea.model.mappers;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignaturaGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Asignatura;
import org.mapstruct.*;

@Mapper
public interface AsignaturaMapper {
    AsignaturaGDto toDto(Asignatura asignatura);
    @InheritInverseConfiguration
    Asignatura toAsignatura(AsignaturaGDto asignaturaDto);
}
