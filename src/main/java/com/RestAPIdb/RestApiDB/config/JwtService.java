package com.RestAPIdb.RestApiDB.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "d0e8f9eaebbc5755d5bbdd1a28b4ce700f6dbc1e62ab89c8f93c176b7a649f36";
    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }
    public String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails
    ){
        return buildToken(extractClaims,userDetails);
    }

    public boolean isTokenValid(String token,UserDetails userDetails)
    {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);

    }


    private static Claims extractAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String buildToken(Map<String,Object> extraClaims, UserDetails userDetails)
    {
        String roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        extraClaims.put("roles",roles);
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date((System.currentTimeMillis())))
                .setExpiration(new Date(System.currentTimeMillis() +  1000 * 60 * 24)) //timp expirare token: 1000ms + 24h
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

}




