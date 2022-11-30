package io.github.entregaapi.service;

import io.github.entregaapi.model.entity.Cliente;

public interface ClienteService {
	Cliente save(Cliente cliente);
	void update(Integer id,Cliente cliente);
	void delete(Integer id);
	Cliente obterClientePorId(Integer id);
}
