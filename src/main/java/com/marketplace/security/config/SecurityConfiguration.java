package com.marketplace.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

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
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout( logout -> logout.logoutUrl("/auth/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) ->
                                SecurityContextHolder.clearContext()));
        return http.build();
    }

}