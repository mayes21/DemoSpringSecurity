package com.amabb.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebAuthorizationConfig {

//    private final CustomAuthenticationProvider customAuthenticationProvider;
//
//    public SpringSecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
//        this.customAuthenticationProvider = customAuthenticationProvider;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // The filter chain
        http.httpBasic(Customizer.withDefaults());
//        http.authenticationProvider(customAuthenticationProvider);
        http.authorizeHttpRequests((authz) -> authz
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }
}
