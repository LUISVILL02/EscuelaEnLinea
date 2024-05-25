package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "administradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "idUser", column = @Column(name = "id_admin"))
@EqualsAndHashCode(callSuper = true)
public class Administrador extends Usuario{
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-5")
    private LocalDate fechaNacimiento;

    @Builder(builderMethodName = "administradorBuilder")
    public Administrador(Long idUser, String nombre, String apellido, String identificacion, String correo, String telefono, String contraseña, Set<Role> roles, LocalDate fechaNacimiento) {
        super(idUser, nombre, apellido, identificacion, correo, telefono, contraseña, roles);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Administrador updateAdmin(Administrador administrador){
        return new Administrador(
                this.getIdUser(),
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getIdentificacion(),
                this.getCorreo(),
                administrador.getTelefono(),
                this.getPassword(),
                this.getRoles(),
                administrador.fechaNacimiento
        );
    }
}

