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

import static com.marketplace.security.userauth.model.Role.*;
import static org.springframework.http.HttpMethod.*;

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
                        //ADMIN
                        .requestMatchers("/admin/**")
                        .hasRole(ADMIN.name())

                        //AUTHENTICATION
                        .requestMatchers("/auth/**")
                        .permitAll()

                        //USERS
                        .requestMatchers(GET,"/users")
                        .permitAll()
                        .requestMatchers(GET,"/users/{id}")
                        .permitAll()
                        .requestMatchers(PATCH,"/users/change-password")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(PATCH,"/users/change-email")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(PATCH,"/users/{id}")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(DELETE,"/users")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())

                        //CONTRACTORS
                        .requestMatchers(POST,"/api/v1/contractor/create")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())

                        //PROFESSIONS
                        .requestMatchers(GET,"/professions/all")
                        .permitAll()
                        .requestMatchers(GET,"/professions/{id}")
                        .permitAll()
                        .requestMatchers(GET,"/professions/category/{name}")
                        .permitAll()
                        .requestMatchers(GET,"/professions/contractor/{id}")
                        .permitAll()
                        .requestMatchers(GET,"/professions/title/{title}")
                        .permitAll()
                        .requestMatchers(POST,"/professions")
                        .hasAnyRole(ADMIN.name(), CONTRACTOR.name())
                        .requestMatchers(PUT,"/professions/{id}")
                        .hasAnyRole(ADMIN.name(), CONTRACTOR.name())
                        .requestMatchers(DELETE,"/professions/{id}")
                        .hasAnyRole(ADMIN.name(), CONTRACTOR.name())

                        //CATEGORIES
                        .requestMatchers(GET,"/categories")
                        .permitAll()
                        .requestMatchers(GET,"/categories/id/{id}")
                        .permitAll()
                        .requestMatchers(GET,"/categories/name/{name}")
                        .permitAll()
                        .requestMatchers(POST,"/categories")
                        .hasAnyRole(ADMIN.name())
                        .requestMatchers(PUT,"/categories/{id}")
                        .hasAnyRole(ADMIN.name())
                        .requestMatchers(DELETE,"/categories/{id}")
                        .hasAnyRole(ADMIN.name())

                        //SERVICES-HISTORY
                        .requestMatchers(GET,"/history/")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(GET,"/history/find/{id}")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(POST,"/history/create")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(PUT,"/history/edit/{id}")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())
                        .requestMatchers(DELETE,"/history/delete/{id}")
                        .hasAnyRole(ADMIN.name(), USER.name(), CONTRACTOR.name())

                        //.anyRequest()
                        //.autenticated()
                        //.permitAll() // permitAll() para poder testear
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