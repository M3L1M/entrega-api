package io.github.entregaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.entregaapi.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
