package com.mysite.springbootboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration    // 스프링의 환경설정 파일을 의미: 스프링 세큐리티의 설정을 위해 사용
@EnableWebSecurity    // 모든 요청 URL 이 스프링 세큐리티의 제어를 받도록 사용: 내부적으로 SpringSecurityFilterChain이 동작하여 URL 필터 적용
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll();    // 모든 인증되지 않은 요청을 허락
        return httpSecurity.build();
    }
}
