package com.idat.EC2LeninAlbinoBodega.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTokenFilter extends OncePerRequestFilter {
   @Autowired
   private JwtUtil jwtUtil;
   @Autowired
   private UsuarioDetailService usuarioDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestHeader= request.getHeader("Authorization");
        String token = null;
        String usuario= null;
        if(requestHeader != null && requestHeader.startsWith("Bearer ")){
            token= requestHeader.substring(7);
            try {
                usuario = jwtUtil.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                logger.info("Argumento de token invalido");
            }
        }else{
            logger.warn("JWT no contiene la palabra Bearer");
        }

        if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails details =this.usuarioDetailService.loadUserByUsername(usuario);
            if(jwtUtil.validateToken(token,details)){
                UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(details,null,details.getAuthorities());
                usuarioToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usuarioToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
