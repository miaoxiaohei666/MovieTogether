package util;

import io.jsonwebtoken.Jwts;
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
    public static String getToken(Integer id) {
        Date date = new Date(System.currentTimeMillis() + 10 * 86400 * 1000);
        String jwtToken = Jwts.builder()
                .claim("userid", id)
                .setId(UUID.randomUUID().toString())
                .setExpiration(date)
                .signWith(K)
                .compact();
        return jwtToken;
    }

    public static String parseUserIDFromToken(String token) {
        Map<String, Object> body;
        try {
            body = Jwts.parserBuilder().setSigningKey(K).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return "";
        }
        return body.get("userid").toString();
    }
}