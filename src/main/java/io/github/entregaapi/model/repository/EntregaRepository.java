package io.github.entregaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.entregaapi.model.entity.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Integer>{

}
