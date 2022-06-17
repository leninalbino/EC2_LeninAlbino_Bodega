package com.idat.EC2LeninAlbinoBodega.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2LeninAlbinoBodega.entity.Cliente;
import com.idat.EC2LeninAlbinoBodega.service.ClienteService;


@RestController
@RequestMapping("/rest/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	@GetMapping("/ListCliente")
	public ResponseEntity<List<Cliente>> ListCliente()throws Exception{
		try {
			List<Cliente> lista=service.listCliente();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
	}
	
	@PostMapping("/saveCliente")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		
			try {
				service.saveCliente(cliente);
				salida.put("mensaje","Registardo Correctamente");
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error " + e.getMessage());
			}
			
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/updateCliente")
	public ResponseEntity<?>updateCliente(@RequestBody Cliente cliente)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.UpdateCliente(cliente);
			salida.put("mensaje","Actualizado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCliente(Long id)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.deleteCliente(id);
			salida.put("mensaje","Eliminado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
}
