package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2LeninAlbinoBodega.entity.Cliente;
import com.idat.EC2LeninAlbinoBodega.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository repo;

	@Override
	public List<Cliente> listCliente() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		repo.save(cliente);
	}

	@Override
	public void UpdateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(cliente);
	}

	@Override
	public void deleteCliente(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Cliente> findById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
