package com.idat.EC2LeninAlbinoBodega.service;

import java.util.List;

import com.idat.EC2LeninAlbinoBodega.entity.Cliente;

public interface ClienteService {
	public List<Cliente> listCliente();
	void  saveCliente(Cliente cliente);
	void UpdateCliente(Cliente cliente);
	void deleteCliente(Long id);
	public List<Cliente>findById(Long Id);
}
