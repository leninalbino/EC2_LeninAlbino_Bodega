package com.idat.EC2LeninAlbinoBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Usuario;
import com.idat.EC2LeninAlbinoBodega.repository.UsuarioRepository;

@Service(value="userService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	@Autowired
	private UsuarioRepository repo;

	@Override
	public List<Usuario> listUsuario() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		repo.save(usuario);
	}

	@Override
	public void UpdateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Usuario> findById(Long Id) {
		// TODO Auto-generated method stub
		return (List<Usuario>) repo.findById(Id).orElse(null);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarios= repo.findByUsuario(usuario);
		if(usuarios == null){
			throw new UsernameNotFoundException("Invalido Usuario o Password");
		}
		return new org.springframework.security.core.userdetails.User(usuarios.getUsuario(), usuarios.getPassword(), getAuthority(usuarios));
	}

	

	private List<SimpleGrantedAuthority> getAuthority(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

			authorities.add(new SimpleGrantedAuthority("ROLES_" + usuario.getRol()));

		return authorities;
	}
	
}
