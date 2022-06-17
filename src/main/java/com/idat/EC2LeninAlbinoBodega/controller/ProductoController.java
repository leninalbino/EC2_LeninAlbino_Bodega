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

import com.idat.EC2LeninAlbinoBodega.entity.Producto;
import com.idat.EC2LeninAlbinoBodega.service.ProdcutoServiceImpl;
import com.idat.EC2LeninAlbinoBodega.service.ProductoService;



@RestController
@RequestMapping("/rest/v1/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/ListProducto")
	public ResponseEntity<List<Producto>> ListProducto()throws Exception{
		try {
			List<Producto> lista=service.listProducto();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
	}
	
	@PostMapping("/saveProducto")
	public ResponseEntity<?> saveProducto(@RequestBody Producto producto)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		
			try {
				service.saveProducto(producto);
				salida.put("mensaje","Registardo Correctamente");
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Error " + e.getMessage());
			}
			
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/updateProducto")
	public ResponseEntity<?>updateUsuario(@RequestBody Producto producto)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.UpdateProducto(producto);
			salida.put("mensaje","Actualizado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducto(Long id)throws Exception{
		Map<String, Object> salida = new HashMap<>();
		try {
			service.deleteProducto(id);
			salida.put("mensaje","Eliminado Correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error " + e.getMessage());
		}
		
	return ResponseEntity.ok(salida);
	}
}
