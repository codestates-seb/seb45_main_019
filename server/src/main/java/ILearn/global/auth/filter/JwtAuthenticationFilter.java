package ILearn.global.auth.filter;

import ILearn.global.auth.jwt.JwtTokenizer;
import ILearn.global.auth.loginDto.LoginDto;
import ILearn.global.auth.utils.CustomAuthorityUtils;
import ILearn.global.response.ApiResponse;
import ILearn.member.entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenizer jwtTokenizer;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenizer jwtTokenizer) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenizer = jwtTokenizer;
    }

    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginDto loginDto = objectMapper.readValue(request.getInputStream(), LoginDto.class);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

            // 사용자 인증 시도
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            return authentication;
        } catch (AuthenticationException e) {
            // 인증 실패 시 400 Bad Request 오류와 사용자 정의 메시지를 반환
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // 사용자 정의 응답 JSON 생성
            ApiResponse<String> apiResponse = new ApiResponse<>(false, 911,"USER_NOT_FOUND", "");

            try (PrintWriter writer = response.getWriter()) {
                // JSON 응답 전송
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(writer, apiResponse);
            } catch (io.jsonwebtoken.io.IOException ex) {
                throw new RuntimeException(ex);
            }

            return null;
        } catch (io.jsonwebtoken.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
//    @SneakyThrows
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        LoginDto loginDto = objectMapper.readValue(request.getInputStream(), LoginDto.class);
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
//
//        return authenticationManager.authenticate(authenticationToken);
//    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws ServletException, IOException {
        Member member = (Member) authResult.getPrincipal();

        addTokenToResponse(member, response);

        this.getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    public void addTokenToResponse(Member member, HttpServletResponse response) {
        String accessToken = delegateAccessToken(member);
        String refreshToken = delegateRefreshToken(member);

        // JWT 토큰을 쿠키로 추가
        Cookie accessTokenCookie = new Cookie("access_token", accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setMaxAge(jwtTokenizer.getAccessTokenExpirationMinutes() * 60);
        accessTokenCookie.setPath("/"); // 쿠키의 경로 설정
        response.addCookie(accessTokenCookie);

        Cookie refreshTokenCookie = new Cookie("refresh_token", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setMaxAge(jwtTokenizer.getRefreshTokenExpirationMinutes() * 60);
        refreshTokenCookie.setPath("/"); // 쿠키의 경로 설정
        response.addCookie(refreshTokenCookie);
    }

    private String delegateAccessToken(Member member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", member.getUsername());
        claims.put("roles", member.getRoles());

        String subject = member.getUsername();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }

    private String delegateRefreshToken(Member member) {
        String subject = member.getUsername();
        Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getRefreshTokenExpirationMinutes());
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);
        return refreshToken;
    }
}