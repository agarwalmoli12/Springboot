package com.database.mongodb.filter;

import java.io.IOException;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.database.mongodb.service.UserDetailsServiceImpl;
import com.database.mongodb.utils.Jwtutil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtfilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private Jwtutil jwtutil; 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String authorizationHeader = request.getHeader("Authorization");
                String username= null;
                String jwt = null;
                if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
                    jwt = authorizationHeader.substring(7);
                    username = jwtutil.extractUsername(jwt);
                }
                if(username!=null){
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if(jwtutil.validateToken(jwt)){
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(jwt, userDetails);
                        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(auth);

                    }
                }
        

  

    
        filterChain.doFilter(request, response);
    }
}
