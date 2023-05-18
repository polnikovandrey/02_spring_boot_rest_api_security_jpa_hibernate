package com.mcfly.crud_rest_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
        httpSecurity.httpBasic();               // Enable basic authentication.
        httpSecurity.csrf().disable();          // There is no need to protect against csrf attacks for REST API (stateless).
        return httpSecurity.build();
    }

    /* Hardcoded users.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        final UserDetails john
                = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        final UserDetails mary
                = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE, MANAGER")
                .build();

        final UserDetails susan
                = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE, MANAGER, ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */
}
