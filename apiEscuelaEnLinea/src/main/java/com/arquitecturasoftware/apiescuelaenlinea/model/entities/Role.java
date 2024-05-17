package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import com.arquitecturasoftware.apiescuelaenlinea.model.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> users = new ArrayList<>();
}
