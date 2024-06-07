package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.ObservacionEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.ObservacionGDto;
import org.springframework.data.domain.Page;

public interface ObservacionService {
    ObservacionEDto save(ObservacionGDto observacionGDto);
    ObservacionEDto findById(Long id);
    ObservacionEDto update(Long id, String descripcion);
    void delete(Long id);
    Page<ObservacionEDto> findAll(Integer page, Integer size);
}
