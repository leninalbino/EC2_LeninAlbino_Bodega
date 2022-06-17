package com.idat.EC2LeninAlbinoBodega.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2LeninAlbinoBodega.entity.Bodega;
import com.idat.EC2LeninAlbinoBodega.service.BodegaService;

import lombok.Delegate;

@RestController
@RequestMapping("/rest/v1/bodega")
public class BodegaController {
	
	@Autowired
	private BodegaService service;
	
	@GetMapping("/ListBodega")
	public ResponseEntity<List<Bodega>> ListBodega()throws Exception{
		try {
			List<Bodega> lista=service.listBodega();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
	}
	
	@PostMapping("/saveBodega")
	public ResponseEntity<?> saveBdega(@RequestBody Bodega bodega)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		
			try {
				service.saveBodeda(bodega);
				salida.put("mensaje","Registardo Correctamente");
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error " + e.getMessage());
			}
			
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/updateBodega")
	public ResponseEntity<?>updateBodega(@RequestBody Bodega bodega)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.UpdateBodega(bodega);
			salida.put("mensaje","Actualizado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBodega(Long id)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.deleteBodega(id);
			salida.put("mensaje","Eliminado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
}
