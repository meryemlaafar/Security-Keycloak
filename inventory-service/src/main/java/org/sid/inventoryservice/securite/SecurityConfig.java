package org.sid.inventoryservice.securite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //autoriser les requêtes HTTP sur les URL commençant par /api/** sans authentification
                .authorizeHttpRequests(ar -> ar
                        .requestMatchers("/api/**","/h2-console/**").permitAll()
                )
                //désactiver la protection contre les frames
                //l'ordre n'est pas important
                .headers(headers -> headers
                        .frameOptions(fo->fo.disable()))
                .authorizeHttpRequests(ar -> ar
                        .anyRequest().authenticated()
                )
                .sessionManagement(sm->sm
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(csrf->csrf.disable())
                .build();
    }
}
