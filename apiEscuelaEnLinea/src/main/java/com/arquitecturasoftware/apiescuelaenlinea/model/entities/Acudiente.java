package com.arquitecturasoftware.apiescuelaenlinea.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "acudientes")
@Data
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "idUser", column = @Column(name = "id_acudiente"))
public class Acudiente extends Usuario{
    private String direccion;

    //relationship
    //cita
    @OneToMany(mappedBy = "acudiente")
    List<Cita> citas;

    //alumno
    @OneToMany(mappedBy = "acudiente")
    List<Alumno> alumnos;

    public Acudiente(String nombre, String apellido,
                     String identificacion, String correo, String telefono,
                     String contraseña, String direccion) {
        super(nombre, apellido, identificacion, correo, telefono, contraseña);
        this.direccion = direccion;
    }

    public Acudiente() {
    }

    @Builder(builderMethodName = "acudienteBuilder")
    public Acudiente(Long idUser, String nombre, String apellido, String identificacion, String correo, String telefono, String contraseña, Set<Role> roles, String direccion) {
        super(idUser, nombre, apellido, identificacion, correo, telefono, contraseña, roles);
        this.direccion = direccion;
    }
}
