package com.idat.EC2LeninAlbinoBodega.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Usuario;
import com.idat.EC2LeninAlbinoBodega.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetailService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuariosRepository;
    
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario usuarios=usuariosRepository.findByUsuario(usuario);

        if(usuarios!= null){
            
            // creamos una lista de GrantedAuthority para agregar objeto de tipo GrantedAuthority
            List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
            // este objeto recibe un atributo de tipo String y los convierte a tipo GrantedAuthority
            GrantedAuthority authority=new SimpleGrantedAuthority(usuarios.getRol());
            // luego le añadimos a la lista
            granted.add(authority);
            return new User(usuarios.getUsuario(), usuarios.getPassword(),granted);
        }else {
            throw new UsernameNotFoundException("El usuario no existe");
        }
    }
}
