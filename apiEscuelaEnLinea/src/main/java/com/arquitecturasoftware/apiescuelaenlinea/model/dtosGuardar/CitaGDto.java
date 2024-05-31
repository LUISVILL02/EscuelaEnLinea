package com.arquitecturasoftware.apiescuelaenlinea.model.dtosGuardar;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaGDto {
    private Long idCita;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String descripcion;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDateTime fechaCreacion;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    private LocalDateTime fechaCita;

    private Long idProfesor;
    private Long idAcudiente;
    private Long idEstadoCita;
}
