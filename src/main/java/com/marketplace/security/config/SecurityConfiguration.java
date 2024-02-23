package com.marketplace.security.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.marketplace.security.userauth.Permission.*;
import static com.marketplace.security.userauth.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz -> authz
                        .requestMatchers("/auth/**")
                        .permitAll()


                        //.requestMatchers("/profession/**").hasAnyRole(ADMIN.name(), USER.name())
                        //.requestMatchers(GET,"/profession").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name())
//                        .requestMatchers(PUT,"/profession/{id}").hasAuthority(ADMIN_UPDATE.name())
//                        .requestMatchers(DELETE,"/profession/{id}").hasAuthority(ADMIN_DELETE.name())
//                        .requestMatchers(POST,"/profession").hasAuthority(USER_CREATE.name())



                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest()
                        //.autenticated()
                        .permitAll() // permitAll() para poder testear
                ))
                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }

}