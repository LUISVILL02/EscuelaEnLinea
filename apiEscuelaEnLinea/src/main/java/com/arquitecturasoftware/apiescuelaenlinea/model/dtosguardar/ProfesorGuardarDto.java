package com.arquitecturasoftware.apiescuelaenlinea.model.dtosguardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfesorGuardarDto extends UsuarioGuardarDto{
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fechaNacimiento;
    private String direccion;
    private List<CitaGuardarDto> citas;
    private List<CursoGuardarDto> cursos;
    private List<ObservacionGuardarDto> observaciones;
    private List<AsignacionGuardarDto> asignaciones;
}
