package com.shawn.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    /*
    如果signKey少一个字母的话会报如下的错
    The specified key byte array is 248 bits which is not secure enough for any JWT HMAC-SHA algorithm.
    The JWT JWA Specification (RFC 7518, Section 3.2) states that keys used
    with HMAC-SHA algorithms MUST have a size >= 256 bits (the key size must be greater than or equal to the hash output size).
      Consider using the Jwts.SIG.HS256.key() builder (or HS384.key() or HS512.key())
       to create a key guaranteed to be secure enough for your preferred HMAC-SHA algorithm.
         See https://tools.ietf.org/html/rfc7518#section-3.2 for more information.
     */
    private static final SecretKey signKey = Keys.hmacShaKeyFor("shawn-shawn-shawn-shawn-shawn-sh".getBytes());

    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分payload中存储的内容
     * @return JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        long expire = 43200000L;
        return Jwts.builder()
                .claims(claims)
                .signWith(signKey)
                .expiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT令牌
     * @return JWT第二部分payload中存储的内容
     */
    public static Claims parseJWT(String jwt) {
        Jws<Claims> claimsJws = Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(jwt);
        return claimsJws.getPayload();
    }
}
