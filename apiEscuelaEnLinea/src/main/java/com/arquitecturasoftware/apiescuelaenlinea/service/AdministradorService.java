package com.arquitecturasoftware.apiescuelaenlinea.service;

import com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar.AdministradorEDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar.AdministradorGDto;
import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Administrador;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    List<AdministradorEDto> findAll();
    Optional<AdministradorEDto> findByNombreCompleto(String nombre, String apellido);
    Optional<AdministradorEDto> findById(Long id);
    void deleteById(Long id);
    AdministradorEDto updateById(AdministradorGDto administrador, long id);
}
