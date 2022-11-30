package io.github.entregaapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinatarioDTO {
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
}
