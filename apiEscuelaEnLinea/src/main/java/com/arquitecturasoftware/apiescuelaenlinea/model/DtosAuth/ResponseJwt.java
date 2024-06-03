package com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseJwt {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String identificacion;
    private String email;
    private String nombre;
    private String apellido;
    private String telefono;
    private List<String> roles;

}
