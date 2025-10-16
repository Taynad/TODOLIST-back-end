package com.tay.springSecurityWithJWT2.security;

import com.tay.springSecurityWithJWT2.exception.UserNotFoundException;
import com.tay.springSecurityWithJWT2.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserRepository userRepository;

    public SecurityFilter(JWTService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String token = recoverToken(request);
            if (token != null){
                //validar o token
                String username = jwtService.validateToken(token);

                //busca o usuário
                UserDetails user = userRepository.findByUsername(username)
                        .map(UserAuthenticated::new)
                        .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

                var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            filterChain.doFilter(request, response);
    }

    public String recoverToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header == null){
            return null;
        }

        return header.replace("Bearer", " ").trim();
    }
}
