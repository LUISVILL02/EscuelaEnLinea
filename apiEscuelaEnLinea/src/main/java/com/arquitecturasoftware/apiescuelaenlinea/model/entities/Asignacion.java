package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "asignaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignacion;

    //relationship
    //profesor
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    //Asignatura
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    //Nota
    @OneToMany(mappedBy = "asignacion")
    private List<Nota> notas;
}
