package com.gdg.gdgbackend.global.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/api/login")
                .loginProcessingUrl("/api/login")
                .defaultSuccessUrl("/api")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .failureUrl("/api/login?isError=true")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
                .logoutSuccessUrl("/api")
        ;

        http.authorizeRequests()
                .antMatchers("/**", "/api/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
        ;

        http.headers().frameOptions().disable();

        http.csrf().disable();

        http.exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPointImpl())
        ;

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer configure() throws Exception {
        return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
