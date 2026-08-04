package com.database.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.database.mongodb.EnableWebSecurity;
import com.database.mongodb.filter.jwtfilter;
import com.database.mongodb.service.UserDetailsServiceImpl;

import jakarta.servlet.Filter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;


@Configuration
@EnableWebSecurity

public class SecurityConfig {//extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private jwtfilter jwtfilter;
    @Bean
    protected DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth
            
               .requestMatchers("/course/**","/user/**").authenticated()
               .requestMatchers("/admin/**").hasRole("ADMIN")
               .anyRequest().permitAll());
                http.sessionManagement(session ->
                     session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                     
                
                http.addFilterBefore(
                    (Filter) jwtfilter, 
                    UsernamePasswordAuthenticationFilter.class);

              return http.build();
              
               


    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
        
    }
    @Bean
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

    
    @Bean
public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration)
        throws Exception {

    return authenticationConfiguration.getAuthenticationManager();
}


}