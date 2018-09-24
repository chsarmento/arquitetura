package br.pucminas.arquiteturaBackend.bibliotecaAPI.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Editora  {

	private Long id;
	private String nome;
	private String cpf;
	
	private List<Livro> livros = new ArrayList<>();
	
	
}
