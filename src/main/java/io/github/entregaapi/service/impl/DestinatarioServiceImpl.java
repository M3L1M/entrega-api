package io.github.entregaapi.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.entregaapi.exception.RegraNegocioException;
import io.github.entregaapi.model.entity.Destinatario;
import io.github.entregaapi.model.repository.DestinatarioRepository;
import io.github.entregaapi.service.DestinatarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DestinatarioServiceImpl implements DestinatarioService {

	@Autowired
	private DestinatarioRepository repository;
	
	@Override
	@Transactional
	public Destinatario save(Destinatario destinatario) {
		
		return repository.save(destinatario);
	}

	@Override
	@Transactional
	public void update(Integer id, Destinatario destinatario) {
		repository
			.findById(id)
			.map(entity -> {
				destinatario.setId(entity.getId());
				return repository.save(destinatario);
			}).orElseThrow(()-> new RegraNegocioException("Destinatario não encontrado na base de dados"));

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository
			.findById(id)
			.map(entity-> {
				repository.delete(entity);
				return Void.TYPE;
			}).orElseThrow(()-> new RegraNegocioException("Destinatario não encontrado na base de dados"));

	}

	@Override
	public Destinatario obterDestinatarioPorId(Integer id) {
		return repository
				.findById(id)
				.map(entity -> {
					return entity;
				}).orElseThrow(()-> new RegraNegocioException("Destinatario não encontrado na base de dados"));
	}

}
