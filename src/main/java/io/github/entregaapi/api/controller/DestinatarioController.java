package io.github.entregaapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.*;
import io.github.entregaapi.api.dto.DestinatarioDTO;
import io.github.entregaapi.model.entity.Destinatario;
import io.github.entregaapi.service.DestinatarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/api/destinatario")
@RestController
public class DestinatarioController {

	@Autowired
	private DestinatarioService service;
	
	
	@PostMapping("")
	@ResponseStatus(CREATED)
	public Destinatario save(@RequestBody DestinatarioDTO dto) {
		Destinatario converter=converter(dto);
		return service.save(converter);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void update(@PathVariable Integer id,@RequestBody DestinatarioDTO dto) {
		Destinatario destinatario=converter(dto);
		service.update(id, destinatario);
	}
	
	@GetMapping("/{id}")
	public Destinatario obterDestinatarioPorId(@PathVariable Integer id) {
		return service.obterDestinatarioPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Integer id){
		service.delete(id);
	}


	private Destinatario converter(DestinatarioDTO dto) {
		Destinatario destinatario=new Destinatario();
		destinatario.setNome(dto.getNome());
		destinatario.setLogradouro(dto.getLogradouro());
		destinatario.setNumero(dto.getNumero());
		destinatario.setComplemento(dto.getComplemento());
		destinatario.setBairro(dto.getBairro());
		return destinatario;
	}
	
}
