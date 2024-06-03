package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "asignaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignatura;
    private String nombre;

    //relationship
    //Asignacion
    @OneToMany(mappedBy = "asignatura")
    private List<Asignacion> asignaciones;
}
