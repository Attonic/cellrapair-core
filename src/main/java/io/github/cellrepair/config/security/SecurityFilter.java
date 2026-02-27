package io.github.cellrepair.config.security;

import io.github.cellrepair.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    public SecurityFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        var token = this.recuperarToken(request);

        if (token != null) {
           var login = tokenService.validarToken(token);
           UserDetails userDetails = userRepository.findByNomeUsuario(login);
           var autenticacao = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
           SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }
        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null){
            return null;
        }

        return authorizationHeader.replace("Bearer ", "");
    }
}
