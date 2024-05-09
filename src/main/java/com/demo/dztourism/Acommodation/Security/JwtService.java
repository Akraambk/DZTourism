package com.demo.dztourism.Acommodation.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.secret-key}")
    private String jwtSecretKey ;

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<String , Claims>() , userDetails) ;

    }

    private String generateToken(HashMap<String, Claims> extraClaims, UserDetails userDetails) {

        return buildToken(extraClaims , userDetails , jwtExpiration);
    }

    private String buildToken(HashMap<String, Claims> extraClaims, UserDetails userDetails, long jwtExpiration) {

        var authorities = userDetails
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList() ;
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setClaims(extraClaims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey())
                .claim("authorities" , authorities)
                .compact() ;

    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecretKey);
        return Keys.hmacShaKeyFor(keyBytes) ;
    }

    public Claims extractAllClaims(String token){

        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody() ;

    }

   public <T> T extractClaim(String token , Function<Claims , T > claimResolver ){
        final Claims claims = extractAllClaims(token) ;
        return claimResolver.apply(claims) ;
   }
   public String extractUserName(String token ){

        return extractClaim(token , Claims ::getSubject ) ;

   }

public boolean isTokenValid(String token , UserDetails userDetails ){

        final String userName = extractUserName(token) ;
      return  userName.equals(userDetails.getUsername()) && !isTokenExpired(token , userDetails) ;
}

    public boolean isTokenExpired(String token, UserDetails userDetails) {

        return extractExpiration(token).before(new Date()) ;
    }

    public Date extractExpiration(String token){

        return extractClaim(token , Claims ::getExpiration) ;
    }

}