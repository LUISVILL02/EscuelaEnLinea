package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "profesores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "idUser", column = @Column(name = "id_profesor"))
public class Profesor extends Usuario{
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
}
