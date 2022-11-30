package io.github.entregaapi.service;

import io.github.entregaapi.model.entity.Destinatario;

public interface DestinatarioService {
	public Destinatario save(Destinatario destinatario);
	public void update(Integer id,Destinatario destinatario);
	public void delete(Integer id);
	public Destinatario obterDestinatarioPorId(Integer id);
	
}
