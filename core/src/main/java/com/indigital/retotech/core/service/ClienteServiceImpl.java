package com.indigital.retotech.core.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigital.retotech.core.model.Cliente;
import com.indigital.retotech.core.repository.ClienteRepository;
import com.indigital.retotech.core.util.FechaUtil;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listar() throws Exception {		
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public void crear(Cliente cliente) throws Exception {
		clienteRepository.save(cliente);
	}

	@Override
	public BigDecimal obtenerPromedioEdades(List<Cliente> clientes) throws Exception {
		
		BigDecimal sumaEdades = new BigDecimal(
				clientes.stream()
				.mapToInt(c -> FechaUtil.calcularEdad(c.getFechaNacimiento(), LocalDate.now()))
				.sum());
		
		BigDecimal cantidadClientes = new BigDecimal(clientes.size()); 
		
		BigDecimal promedio = sumaEdades.divide(cantidadClientes, 2, RoundingMode.HALF_UP);
		
		return promedio;
	}

	@Override
	public BigDecimal obtenerDesviacionEstandarEdades(List<Cliente> clientes) throws Exception {
		
		BigDecimal variacionEstandar = BigDecimal.ZERO;
		
		BigDecimal totalElementos = new BigDecimal(clientes.size());
		
		BigDecimal media = obtenerPromedioEdades(clientes);
		
		BigDecimal sumaCuadradosDistancia = BigDecimal.ZERO;
		
		for (Cliente cliente : clientes) {
			BigDecimal cuadradoDistancia = BigDecimal.ZERO;
			
			BigDecimal edad = new BigDecimal(FechaUtil.calcularEdad(cliente.getFechaNacimiento(), LocalDate.now()));
			
			cuadradoDistancia = (edad.subtract(media)).pow(2).setScale(2, RoundingMode.HALF_UP);
			
			sumaCuadradosDistancia = sumaCuadradosDistancia.add(cuadradoDistancia);
		}
		
		variacionEstandar = new BigDecimal(Math.sqrt(sumaCuadradosDistancia.divide(totalElementos, 2 , RoundingMode.HALF_UP).doubleValue()))
				.setScale(2, RoundingMode.HALF_UP);
		
		return variacionEstandar;
	}
	
	
}
