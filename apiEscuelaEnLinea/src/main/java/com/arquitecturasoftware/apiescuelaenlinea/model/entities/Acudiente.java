package com.arquitecturasoftware.apiescuelaenlinea.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "acudientes")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
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
}
