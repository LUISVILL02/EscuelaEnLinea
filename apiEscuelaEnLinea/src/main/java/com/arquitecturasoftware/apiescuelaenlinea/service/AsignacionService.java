package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AsignacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AsignacionGDto;

import java.util.List;

public interface AsignacionService {
    AsignacionEDto hacerAsignacion(AsignacionGDto asignacionGDto);
    AsignacionEDto buscarAsignacion(Long idAsignacion);
    Boolean eliminarAsignacion(Long idAsignacion);

    List<String> saveAsignaciones(List<AsignacionGDto> asignaciones);
}
