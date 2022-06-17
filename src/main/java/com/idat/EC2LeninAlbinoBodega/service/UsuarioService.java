package com.idat.EC2LeninAlbinoBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Usuario;
import com.idat.EC2LeninAlbinoBodega.repository.UsuarioRepository;


public interface UsuarioService {

	
	
	public List<Usuario> listUsuario();
	void  saveUsuario(Usuario usuario);
	void UpdateUsuario(Usuario usuario);
	void deleteUsuario(Long id);
	public List<Usuario>findById(Long Id);
	
	
	
	
	
}
