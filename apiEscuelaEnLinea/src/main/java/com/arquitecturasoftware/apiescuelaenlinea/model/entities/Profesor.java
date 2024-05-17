package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "idUser", column = @Column(name = "id_profesor"))
@EqualsAndHashCode(callSuper = true)
public class Profesor extends Usuario {
    private LocalDate fechaNacimiento;
    private String direccion;

    //relationship
    //cita
    @OneToMany(mappedBy = "profesor")
    private List<Cita> citas;

    //curso
    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    //observacion
    @OneToMany(mappedBy = "profesor")
    private List<Observacion> observaciones;

    //asignacion
    @OneToMany(mappedBy = "profesor")
    private List<Asignacion> asignaciones;

    @Builder(builderMethodName = "profesorBuilder")
    public Profesor(Long idUser, String nombre, String apellido, String identificacion, String correo, String telefono, String contraseña, Set<Role> roles, LocalDate fechaNacimiento, String direccion) {
        super(idUser, nombre, apellido, identificacion, correo, telefono, contraseña, roles);
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
}
