package com.arquitecturasoftware.apiescuelaenlinea.model.DtosAuth;

import lombok.Data;

import java.util.List;

@Data
public class ResponseJwt {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String identificacion;
    private String email;
    private List<String> roles;
    public ResponseJwt(String accessToken, Long id, String identificacion, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.identificacion = identificacion;
        this.email = email;
        this.roles = roles;
    }
}