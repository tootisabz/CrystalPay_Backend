package com.tootisabz.CrystalPay.Application.Security;

import com.tootisabz.CrystalPay.Application.Security.AccessControl.RBAC;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtil jwtUtil;

    @Qualifier("requestMappingHandlerMapping")
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;


    @Override
    protected void doFilterInternal(HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        // Get the handler for the current request
        try {
            // Attempt to get the handler (controller method)
            HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);

            if (handlerExecutionChain != null) {
                Object handler = handlerExecutionChain.getHandler(); // Get the actual handler object

                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;

                    RBAC RBACCLassAnnotation = handlerMethod.getBeanType().getAnnotation(RBAC.class);
                    RBAC RBACMethodAnnotation = handlerMethod.getMethod().getAnnotation(RBAC.class);
                    if (RBACCLassAnnotation != null || RBACMethodAnnotation != null) {
                     System.out.println("RBACAnnotation Exists");
                    }

                    String controllerName = handlerMethod.getBeanType().getSimpleName();
                    String actionName = handlerMethod.getMethod().getName();
                    // Log or use the controller and action names
                    System.out.println("Controller: " + controllerName + ", Action: " + actionName);
                }
            } else {
                System.out.println("No handler found for the request.");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }






        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (jwtUtil.validateToken(jwt, username)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        username, null, new ArrayList<>());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
}
