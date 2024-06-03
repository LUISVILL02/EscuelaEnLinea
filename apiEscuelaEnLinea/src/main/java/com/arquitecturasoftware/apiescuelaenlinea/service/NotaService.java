package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.NotaEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.NotaGDto;

public interface NotaService {
    NotaEDto save(NotaGDto notaGDto);
    NotaEDto findById(Long id);

    NotaEDto findByNombreAndIdAlumno(String nombre, Long idAlumno);

    NotaEDto update(Float nota, Long idNota);
}
