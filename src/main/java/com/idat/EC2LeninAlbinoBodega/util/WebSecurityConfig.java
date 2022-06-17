package com.idat.EC2LeninAlbinoBodega.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioDetailService usuarioDetailService;

    @Autowired
    private JWTokenFilter filter;
    @Autowired
    private EntryPoint entryPoint;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("lenin").password(encriptado().encode("123456")).roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("albino").password(encriptado().encode("123456")).roles("ALUMNO");
        auth.userDetailsService(usuarioDetailService).passwordEncoder(encriptado());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.authorizeRequests()
        //        .antMatchers("/rest/v1/Listproducto/**").access("hasRole('ROLE_USER')")// autorizacion a usuarios
          //      //.antMatchers("/rest/v1/producto/**").permitAll() // autorizacion a todo los usuario
            //    .and()
              //  .httpBasic()
               // .and()
               // .csrf().disable();// desactivar protocolo de validacion de a nivel de explorador


        http.authorizeRequests()
                .antMatchers("/rest/v1/usuarios/crearToken").permitAll()
                .antMatchers("/rest/v1/producto/listProducto/**").hasAnyRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
    @Bean
    public PasswordEncoder encriptado(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
