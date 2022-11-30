package io.github.entregaapi.service;

import io.github.entregaapi.model.entity.Entrega;

public interface EntregaService {
	public Entrega save(Entrega entrega);
	public void update(Integer id, Entrega entrega);
	public Entrega obterEntregaPorId(Integer id);
	public void delete(Integer id);
}
