package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Producto;
import com.idat.EC2LeninAlbinoBodega.repository.ProductoRepository;

@Service
public class ProdcutoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repo;

	@Override
	public List<Producto> listProducto() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveProducto(Producto producto) {
		// TODO Auto-generated method stub
		repo.save(producto);
	}

	@Override
	public void UpdateProducto(Producto producto) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(producto);
	}

	@Override
	public void deleteProducto(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Producto> findById(Long Id) {
		// TODO Auto-generated method stub
		return (List<Producto>) repo.findById(Id).orElse(null);
	}
}
