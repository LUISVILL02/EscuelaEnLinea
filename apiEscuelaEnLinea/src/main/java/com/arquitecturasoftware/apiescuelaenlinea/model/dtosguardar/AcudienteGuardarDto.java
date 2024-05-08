package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcudienteGuardarDto extends UsuarioGuardarDto{
    private String direccion;
    private List<AlumnoGuardarDto> alumnos;
    private List<CitaGuardarDto> citas;
}
