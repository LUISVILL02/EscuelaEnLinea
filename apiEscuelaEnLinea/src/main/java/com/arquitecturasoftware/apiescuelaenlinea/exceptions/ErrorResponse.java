package com.arquitecturasoftware.apiescuelaenlinea.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;
    private String uri;
}
