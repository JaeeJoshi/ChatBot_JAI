package com.example.JAI3.config;

//port java.beans.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//port org.springframework.security.core.userdetails.User;
//port org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

////rt org.springframework.security.config.annotation.web.configurers.Customizer;


@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("user")
                .password("{noop}password") // Use {noop} to disable encoding (for demo)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user); // ✅ register the user
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
