package com.indigital.retotech.core.integration;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.indigital.retotech.core.model.Cliente;
import com.indigital.retotech.core.repository.ClienteRepository;

public class StartDatabaseTest extends AbstractIntegrationTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
    @Disabled
    void crearClientes() {
        clienteRepository.deleteAll();
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Omar");
        cliente.setApellido("Ccoa");
        cliente.setFechaNacimiento(LocalDate.now());
        
        clienteRepository.save(cliente);
    }

}
