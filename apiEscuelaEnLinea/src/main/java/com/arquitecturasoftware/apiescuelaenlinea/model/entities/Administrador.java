package com.arquitecturasoftware.apiescuelaenlinea.model.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "administradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "idUser", column = @Column(name = "id_admin"))
public class Administrador extends Usuario{
    private LocalDate fechaNacimiento;
}
