package com.arquitecturasoftware.apiescuelaenlinea.model.dtosenviar;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AcudienteEnviarDto extends UsuarioEnviarDto{
    private String direccion;
    private List<String> Nombrealumno;
    private List<CitaEnviarDto> citas;
}
