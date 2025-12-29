package com.Focus.SpringSecurityEx.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Service
public class JWTServices{
    private String secretKey="";


     public JWTServices() throws NoSuchAlgorithmException {
         KeyGenerator KeyGen = KeyGenerator.getInstance("HmacSHA256");
         SecretKey sk = KeyGen.generateKey();
         secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
     }
    public String generateToken(String username) {

        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*60*30))
                .and() // Exits claims builder and returns to JWT builder
                .signWith(getKey()) // Signs token using HMAC-SHA256
                .compact(); // Converts token into String
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // converting secretKey into bytes using Base64 cause hmacShaKeyFor accepts byte
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
         return "";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
         return true ;
    }
}
