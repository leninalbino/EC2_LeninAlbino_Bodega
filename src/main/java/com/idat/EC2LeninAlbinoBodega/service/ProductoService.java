package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import com.idat.EC2LeninAlbinoBodega.entity.Producto;


public interface ProductoService {
	
	public List<Producto> listProducto();
	void  saveProducto(Producto producto);
	void UpdateProducto(Producto producto);
	void deleteProducto(Long id);
	public List<Producto>findById(Long Id);
}
