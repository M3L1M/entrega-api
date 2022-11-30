package io.github.entregaapi.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.entregaapi.exception.RegraNegocioException;
import io.github.entregaapi.model.entity.Cliente;
import io.github.entregaapi.model.repository.ClienteRepository;
import io.github.entregaapi.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	@Transactional
	public void update(Integer id, Cliente cliente) {
		repository
			.findById(id)
			.map(entity-> {
				cliente.setId(entity.getId());
				return repository.save(cliente);
			}).orElseThrow(()-> new RegraNegocioException("Cliente não encontrado na base de dados"));

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository
			.findById(id)
			.map(entity -> {
				repository.delete(entity);
				return Void.TYPE;
			}).orElseThrow(()-> new RegraNegocioException("Cliente não encontrado na base de dados"));


	}

	@Override
	public Cliente obterClientePorId(Integer id) {
		return repository
				.findById(id)
				.map(entity-> {
					return entity;
				}).orElseThrow(()-> new RegraNegocioException("Cliente não encontrado na base de dados"));
	}

}
