package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Bodega;
import com.idat.EC2LeninAlbinoBodega.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService{
	@Autowired
	private BodegaRepository repo;

	@Override
	public List<Bodega> listBodega() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveBodeda(Bodega bodega) {
		// TODO Auto-generated method stub
		repo.save(bodega);
	}

	@Override
	public void UpdateBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(bodega);
	}

	@Override
	public void deleteBodega(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Bodega> findById(Long Id) {
		// TODO Auto-generated method stub
		return (List<Bodega>) repo.findById(Id).orElse(null);
	}
	
	
	
}
