package com.matchgetit.backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c->
                {
                    c.disable();//restApi에서는 csrf 인증 필요x
                })
                .authorizeRequests()
                .requestMatchers("/matchGetIt/auth/**").permitAll()
                .requestMatchers("/matchGetIt/naver/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .anyRequest().access("@securityConfig.hasValidToken(request)");
        return http.build();
    }//세션에 있는 토큰을 인증하는 로직

    public boolean hasValidToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if (token == null) {
            return false;
        }
        System.out.println(jwtTokenProvider.decodeToken(token));
        System.out.println(jwtTokenProvider.validateToken(token));
        return jwtTokenProvider.validateToken(token);
    }//jwt 토큰 인증을 마쳐야 true가 뜨고 접근 가능함!
}