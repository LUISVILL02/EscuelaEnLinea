package com.arquitecturasoftware.apiescuelaenlinea.security.jwt;

import com.arquitecturasoftware.apiescuelaenlinea.model.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;


@Service
public class JwtUtils {
    @Value("${escuela-en-line.app.jwtSecret}")
    private String SECRET_KEY;
    @Value("${escuela-en-line.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String getToken(Usuario usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    private String getToken(HashMap<String, Object> extraClaims, Usuario usuario) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .claim("userId", usuario.getIdUser())
                .claim("email", usuario.getCorreo())
                .subject(usuario.getIdentificacion())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ jwtExpirationMs))
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    private Claims getAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}
