package com.arquitecturasoftware.apiescuelaenlinea.initializer;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.EstadoAsistencia;
import com.arquitecturasoftware.apiescuelaenlinea.model.enums.EEstadoAsistencia;
import com.arquitecturasoftware.apiescuelaenlinea.repositories.EstadoAsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Autowired
    private EstadoAsistenciaRepository estadoAsistenciaRepository;

    @Bean
    public ApplicationRunner initializer(){
        return args -> {
            Arrays.stream(EEstadoAsistencia.values()).forEach(estadoAsistencia -> {
                if (!estadoAsistenciaRepository.existsByEstado(estadoAsistencia)){
                    estadoAsistenciaRepository.save(EstadoAsistencia.builder().estado(estadoAsistencia).build());
                }
            });
        };
    }
}
