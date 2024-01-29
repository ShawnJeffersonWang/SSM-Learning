package com.shawn;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class WebManagementApplicationTests {

//    @Test
//    public void testUUID() {
//        for(int i=0;i<1000;i++){
//            String uuid = UUID.randomUUID().toString();
//            System.out.println(uuid);
//        }
//    }

    /**
     * 生成JWT
     * 单元测试与spring环境无关，可以将@SpringBootTest注释掉，不然会加载整个spring环境
     */
    @Test
    public void testGenJwt() {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id", 1);
//        claims.put("name", "tom");
//
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "shawn")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .compact();
//        String jws = Jwts.builder().subject("joe").signWith(key).compact();
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

//        SecretKey key = Jwts.SIG.HS256.key().build();
        SecretKey secretKey = Keys.hmacShaKeyFor("shawn-shawn-shawn-shawn-shawn-sh".getBytes());
        String jws = Jwts.builder()
                .signWith(secretKey)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jws);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt() {
//        Claims claims = Jwts.parser()
//                .setSigningKey("shawn")
//                .parseClaimsJws("")
//                .getBody();
//        System.out.println(claims);
//        SecretKey key = Jwts.SIG.HS256.key().build();
        SecretKey secretKey = Keys.hmacShaKeyFor("shawn-shawn-shawn-shawn-shawn-sh".getBytes());
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims("eyJhbGciOiJIUzI1NiJ9" +
                        ".eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNjUzMzQyM30" +
                        ".-DvLhqHN8k84aH6dP0NdqDNWOGFg32QLASqxu9dbnvI")
                .getPayload();
        System.out.println(claims);
    }
}
