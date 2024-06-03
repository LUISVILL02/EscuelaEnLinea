package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaGDto {

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDate fecha;

    @Min(value = 1, message = "El periodo debe ser al menos 1")
    @Max(value = 4, message = "El periodo no puede ser más de 4")
    private Integer periodo;

    @NotBlank(message = "El nombre de la actividad es obligatorio")
    private String nombreActividad;

    @Min(value = 0, message = "La nota no puede ser menor a 0")
    @Max(value = 10, message = "La nota no puede ser mayor a 10")
    private Float nota;

    private Long idAlumno;
    private Long idAsignacion;
}
