package com.arquitecturasoftware.apiescuelaenlinea.model.dtosEnviar;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEDto {
    private Long idUser;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "El identificador no puede estar vacío")
    @Pattern(regexp = "[A-Za-z0-9_-]+", message = "El identificador contiene caracteres no válidos")
    private String identificador;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe ser válido")
    private String correo;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "El teléfono debe ser válido")
    private String telefono;

    @NotNull(message = "Los roles no pueden ser nulos")
    @Size(min = 1, message = "Debe tener al menos un rol")
    private Set<@NotBlank(message = "El rol no puede estar vacío") String> roles;
}
