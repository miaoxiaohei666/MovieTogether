package util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JWT {
    public static class Token {
        public String token;
    }
    static String secret = "JO6HN3NGIU25G2FIG8V7VD6CK9B6T2Z5";
    static SecretKey K = Keys.hmacShaKeyFor(secret.getBytes());
    /**
     * 生成 token
     */
    public static String getToken(String phone, Integer role) {

        Date date = new Date(System.currentTimeMillis() + 10 * 86400 * 1000);
        String jwtToken = Jwts.builder()
                .claim("phone", phone)
                .claim("role", role)

                .setId(UUID.randomUUID().toString())
                .setExpiration(date)
//                .signWith(SignatureAlgorithm.HS512, secret)
                .signWith(K)
                .compact();
        return jwtToken;
    }

    public static String parsePhoneFromToken(String token) {
        Map<String, Object> body;
        try {
//            body = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
            body = Jwts.parserBuilder().setSigningKey(K).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return "";
        }

        return body.get("phone").toString();

    }

    public static String parseRoleFromToken(String token) {
        Map<String, Object> body;
        try {
            body = Jwts.parserBuilder().setSigningKey(K).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return "";
        }

        return body.get("role").toString();
    }

}