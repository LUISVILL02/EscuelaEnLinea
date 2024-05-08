package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCitaGuardarDto {
    private Long idEstadoCita;
    private String nombre;
    private List<CitaGuardarDto> citas;
}
