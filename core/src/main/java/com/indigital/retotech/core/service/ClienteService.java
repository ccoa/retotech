package com.indigital.retotech.core.service;


import java.math.BigDecimal;
import java.util.List;

import com.indigital.retotech.core.model.Cliente;


public interface ClienteService {
	
	List<Cliente> listar() throws Exception;
	
	void crear(Cliente cliente) throws Exception;
	
	BigDecimal obtenerPromedioEdades(List<Cliente> clientes) throws Exception;
	
	BigDecimal obtenerDesviacionEstandarEdades(List<Cliente> clientes) throws Exception;
}
