package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Comentario  {

	private Long id;
	private String descricao;
	
}
