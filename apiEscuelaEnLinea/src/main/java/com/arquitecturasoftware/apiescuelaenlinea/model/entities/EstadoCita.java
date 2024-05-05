package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "estados_citas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstadoCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoCita;
    private String nombre;

    //relationship
    //cita
    @OneToMany(mappedBy = "estadoCita")
    List<Cita> citas;
}
