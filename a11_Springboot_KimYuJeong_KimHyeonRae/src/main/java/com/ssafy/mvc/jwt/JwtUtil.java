package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "SSAFY_FinalProject_KimYuJeong_KimHyeonRae_SecretKey";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	// 토큰 생성
	public String createToken(String name, String userId) {
	    Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 유효기간 : 24시간
	    
	    return Jwts.builder().header().add("typ", "JWT").and()
	            .claim("name", name)
	            .claim("userId", userId) // userId 추가
	            .expiration(exp)
	            .signWith(secretKey).compact();
	}
	
	// 유효성 검증
	public Jws<Claims> validate(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
}
