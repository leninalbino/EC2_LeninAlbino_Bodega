package com.idat.EC2LeninAlbinoBodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.EC2LeninAlbinoBodega.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsuario(String usuario);
}
