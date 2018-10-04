package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Livro  {

	private Long id;
	private String isbn;
	private String titulo;
	private Double valor;
	
	private List<Comentario> comentarios = new ArrayList<>();
	
	
}
