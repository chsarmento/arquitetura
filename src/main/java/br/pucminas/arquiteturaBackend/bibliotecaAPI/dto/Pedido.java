package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Pedido  {

	private Long id;
	private Cliente cliente;
	private List<Livro> livros;
	private Double valor;
	private String situacao;
	
	private List<Comentario> comentarios = new ArrayList<>();

}
