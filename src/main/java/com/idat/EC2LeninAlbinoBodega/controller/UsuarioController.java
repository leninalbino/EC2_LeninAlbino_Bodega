package com.idat.EC2LeninAlbinoBodega.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2LeninAlbinoBodega.DTO.UsuarioRequestDTO;
import com.idat.EC2LeninAlbinoBodega.DTO.UsuarioResponseDTO;
import com.idat.EC2LeninAlbinoBodega.entity.Usuario;
import com.idat.EC2LeninAlbinoBodega.service.UsuarioService;
import com.idat.EC2LeninAlbinoBodega.util.JwtUtil;
import com.idat.EC2LeninAlbinoBodega.util.UsuarioDetailService;


@RestController
@RequestMapping("/rest/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/ListBodega")
	public ResponseEntity<List<Usuario>> ListUsuario()throws Exception{
		try {
			List<Usuario> lista=service.listUsuario();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
	}
	
	@PostMapping("/saveUsuario")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		
			try {
				service.saveUsuario(usuario);
				salida.put("mensaje","Registardo Correctamente");
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error " + e.getMessage());
			}
			
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/updateUsuario")
	public ResponseEntity<?>updateUsuario(@RequestBody Usuario usuario)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.UpdateUsuario(usuario);
			salida.put("mensaje","Actualizado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUsuario(Long id)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.deleteUsuario(id);
			salida.put("mensaje","Eliminado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
	
	@Autowired
	private JwtUtil util;
	@Autowired
	private UsuarioDetailService serviceUser;

	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO dto){

		UserDetails userDetails = serviceUser.loadUserByUsername(dto.getUsuario());
		return ResponseEntity.ok(new UsuarioResponseDTO(util.generateToken(userDetails.getUsername())));
	}
}
