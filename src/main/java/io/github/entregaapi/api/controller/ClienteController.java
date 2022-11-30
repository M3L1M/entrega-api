package io.github.entregaapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.entregaapi.api.dto.ClienteDTO;
import io.github.entregaapi.model.entity.Cliente;
import io.github.entregaapi.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/cliente")
@RestController
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@PostMapping("")
	@ResponseStatus(CREATED)
	public Cliente save(@RequestBody ClienteDTO dto) {
		Cliente converterCliente=converter(dto);
		return service.save(converterCliente);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void update(@PathVariable Integer id,@RequestBody ClienteDTO dto) {
		Cliente cliente=converter(dto);
		service.update(id, cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId(@PathVariable Integer id) {
		return service.obterClientePorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
	private Cliente converter(ClienteDTO dto) {
		Cliente cliente=new Cliente();
		cliente.setEmail(dto.getEmail());
		cliente.setNome(dto.getNome());
		cliente.setTelefone(dto.getTelefone());
		return cliente;
	}
}
