package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import lombok.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaEDto {
    private Long idCita;
    private String descripcion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaCreacion;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaCita;
    private String nombreProfesor;
    private String apellidoProfesor;
    private String nombreAcudiente;
    private String apellidoAcudiente;
    private String estadoCita;
}
