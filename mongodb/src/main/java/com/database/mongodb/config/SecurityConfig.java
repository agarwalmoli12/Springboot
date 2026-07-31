package com.database.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.database.mongodb.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(null)
               .antMatchers("/course/**").authenticated()
               .anyRequest().permitAll()
               .and()
               .httpBasic();



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        super.configure(auth);
        User user= 
    }


}