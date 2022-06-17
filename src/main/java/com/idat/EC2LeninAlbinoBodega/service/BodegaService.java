package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import com.idat.EC2LeninAlbinoBodega.entity.Bodega;

public interface BodegaService {
	
	public List<Bodega> listBodega();
	void  saveBodeda(Bodega bodega);
	void UpdateBodega(Bodega bodega);
	void deleteBodega(Long id);
	public List<Bodega>findById(Long Id);
}
