package com.indigital.retotech.cliente.controller;

import io.swagger.annotations.ApiOperation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.indigital.retotech.cliente.dto.ClienteDto;
import com.indigital.retotech.cliente.dto.KpiCliente;
import com.indigital.retotech.core.model.Cliente;
import com.indigital.retotech.core.service.ClienteService;
import com.indigital.retotech.core.util.FechaUtil;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/creacliente")
	@ApiOperation(value = "Crear un cliente.")
	public ResponseEntity<String> crear(@RequestBody ClienteDto clienteDto) {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setNombre(clienteDto.getNombre());
			cliente.setApellido(clienteDto.getApellido());
			cliente.setFechaNacimiento(FechaUtil.convertirStringAlocalDate(clienteDto.getFechaNacimiento()));
			
			clienteService.crear(cliente);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@GetMapping("/kpideclientes")
	@ApiOperation(value = "Obtener promedio de edades y variacion estandar de edades de los clientes", response = KpiCliente.class)
	public ResponseEntity<Object> obtenerKpis() {
		
		KpiCliente kpiClienteBean = new KpiCliente();
		
		try {
			
			List<Cliente> clientes = clienteService.listar();
			
			if (!clientes.isEmpty()) {
				
				kpiClienteBean.setPromedioEdades(clienteService.obtenerPromedioEdades(clientes));
				
				kpiClienteBean.setDesviacionEstandarEdades(clienteService.obtenerDesviacionEstandarEdades(clientes));
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(kpiClienteBean, HttpStatus.OK);
	}
	
	@GetMapping("/listclientes")
	@ApiOperation(value = "Listar clientes con fecha probable de muerte de cada uno.", response = List.class)
	public ResponseEntity<Object> listar() {
		
		List<ClienteDto> clientesBeans = new ArrayList<>();
		
		try {
			
			List<Cliente> clientes = clienteService.listar();
			
			for (Cliente cliente : clientes) {
				ClienteDto clienteDto = new ClienteDto();
				clienteDto.setId(cliente.getId());
				clienteDto.setNombre(cliente.getNombre());
				clienteDto.setApellido(cliente.getApellido());
				clienteDto.setEdad(FechaUtil.calcularEdad(cliente.getFechaNacimiento(), LocalDate.now()));
				clienteDto.setFechaNacimiento(FechaUtil.convertirLocalDateAstring(cliente.getFechaNacimiento()));
				clienteDto.setFechaProbableMuerte(FechaUtil.obtenerFechaProbableMuerte(cliente.getFechaNacimiento()));
				
				clientesBeans.add(clienteDto);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(clientesBeans, HttpStatus.OK);
	}

}
