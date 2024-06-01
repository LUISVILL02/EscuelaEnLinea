package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import com.arquitecturasoftware.apiescuelaenlinea.model.enums.EEstadoAsistencia;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estados_asistencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstadoAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoAsistencia;
    @Enumerated(EnumType.STRING)
    private EEstadoAsistencia estado;

    //relationship
    //asistencia
    @OneToMany(mappedBy = "estadoAsistencia")
    private List<Asistencia> asistencias;
}
