package br.pucminas.arquiteturaBackend.bibliotecaAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Autor;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Carrinho;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Cliente;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Comentario;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Editora;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Livro;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.dto.Pedido;
import br.pucminas.arquiteturaBackend.bibliotecaAPI.enums.EnumSituacaoPedido;

@RestController
@RequestMapping("/v1/public/")
public class LivrariaController {

	private List<Cliente> clientes = new ArrayList<>();
	private List<Livro> livros = new ArrayList<>();
	private List<Autor> autores = new ArrayList<>();
	private List<Editora> editoras = new ArrayList<>();
	private List<Carrinho> carrinhos = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();

	// Clientes
	@GetMapping("clientes")
	public List<Cliente> todosClientes() {
		return clientes;
	}

	@PostMapping("clientes")
	Cliente newClient(@RequestBody Cliente cliente) {

		cliente.setId(new Long(new Random().nextInt(100)));
		clientes.add(cliente);

		return cliente;
	}

	@PutMapping("clientes/{id}")
	Cliente replaceCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

		clientes.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setNome(cliente.getNome());
		});

		return cliente;
	}

	@DeleteMapping("clientes/{id}")
	void deleteCliente(@PathVariable Long id) {
		clientes.removeIf(p -> p.getId().equals(id));
	}

	// Livros
	@GetMapping("livros")
	public List<Livro> todosLivros() {
		return livros;
	}

	@GetMapping("livros/{criterio}")
	public List<Livro> pesquisaLivros(@PathVariable String criterios) {
		return livros;
	}
	
	@PostMapping("livros")
	Livro newlivros(@RequestBody Livro livro) {

		livro.setId(new Long(new Random().nextInt(100)));
		livros.add(livro);

		return livro;
	}

	@PutMapping("livros/{id}")
	Livro replaceLivros(@RequestBody Livro livro, @PathVariable Long id) {

		livros.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setIsbn(livro.getIsbn());
			p.setTitulo(livro.getTitulo());
		});

		return livro;
	}

	@PutMapping("livros/{id}/comentario")
	Livro addComentatioLivros(@RequestBody Comentario comentario, @PathVariable Long id) {
		livros.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.getComentarios().add(comentario);
		});

		return (Livro) livros.stream().filter(p -> p.getId().equals(id));

	}

	@DeleteMapping("livros/{id}")
	void deleteLivros(@PathVariable Long id) {
		clientes.removeIf(p -> p.getId().equals(id));
	}

	// Autor
	@GetMapping("autores")
	public List<Autor> todosAutores() {
		return autores;
	}

	@PostMapping("autores")
	Autor newAutor(@RequestBody Autor autor) {

		autor.setId(new Long(new Random().nextInt(100)));
		autores.add(autor);

		return autor;
	}

	@PutMapping("autores/{id}")
	Autor replaceAutor(@RequestBody Autor autor, @PathVariable Long id) {

		autores.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setNome(autor.getNome());
			p.setCpf(autor.getCpf());
		});

		return autor;
	}

	@DeleteMapping("autores/{id}")
	void deleteAutor(@PathVariable Long id) {
		autores.removeIf(p -> p.getId().equals(id));
	}

	@GetMapping("autores/{idAutor}/livros")
	public List<Autor> obterAutoresDoLivro() {
		return autores;
	}

	// editora
	@GetMapping("editoras")
	public List<Editora> todasEditoras() {
		return editoras;
	}

	@PostMapping("editoras")
	Editora newEditora(@RequestBody Editora editora) {

		editora.setId(new Long(new Random().nextInt(100)));
		editoras.add(editora);

		return editora;
	}

	@PutMapping("editoras/{id}")
	Editora replaceCliente(@RequestBody Editora editora, @PathVariable Long id) {

		editoras.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setNome(editora.getNome());
			p.setCpf(editora.getCpf());
		});

		return editora;
	}

	@DeleteMapping("editoras/{id}")
	void deleteEditora(@PathVariable Long id) {
		editoras.removeIf(p -> p.getId().equals(id));
	}

	@GetMapping("autores/{idEditora}/livros")
	public List<Autor> obterLivrosPorEditora() {
		return autores;
	}

	// carrinho de compras
	@GetMapping("carrinhos")
	public List<Carrinho> todosCarrinhos() {
		return carrinhos;
	}

	@PostMapping("carrinhos")
	Carrinho newCarrinho(@RequestBody Carrinho carrinho) {

		carrinho.setId(new Long(new Random().nextInt(100)));
		carrinhos.add(carrinho);

		return carrinho;
	}

	@PutMapping("carrinhos/{id}")
	Carrinho replaceCarrinho(@RequestBody Carrinho carrinho, @PathVariable Long id) {

		carrinhos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setCliente(carrinho.getCliente());
			p.setLivros(carrinho.getLivros());
		});

		return carrinho;
	}

	@DeleteMapping("carrinhos/{id}")
	void deleteCarrinho(@PathVariable Long id) {
		carrinhos.removeIf(p -> p.getId().equals(id));
	}

	@PutMapping("carrinhos/{id}/pago")
	Carrinho gerarPedido(@RequestBody Carrinho carrinho, @PathVariable Long id) {

		carrinhos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setCliente(carrinho.getCliente());
			p.setLivros(carrinho.getLivros());
		});

		return carrinho;
	}
	
	// pedido
	@GetMapping("pedidos")
	public List<Pedido> todosPedidos() {
		return pedidos;
	}

	@PostMapping("pedidos")
	Pedido newPedido(@RequestBody Pedido pedido) {

		pedido.setId(new Long(new Random().nextInt(100)));
		pedidos.add(pedido);

		return pedido;
	}

	@PutMapping("pedidos/{id}")
	Pedido replacePedido(@RequestBody Pedido pedido, @PathVariable Long id) {

		pedidos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setValor(pedido.getValor());
		});

		return pedido;
	}

	@DeleteMapping("pedidos/{id}")
	void deletePedido(@PathVariable Long id) {
		pedidos.removeIf(p -> p.getId().equals(id));
	}
	
	// manutenção da situação do pedido
	@PutMapping("pedidos/{id}/situacao")
	String obterSituacaoPedido(@PathVariable Long id) {

		Pedido pedido = pedidos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		return pedido != null ? pedido.getSituacao() : null;
	}

	@PutMapping("pedidos/{id}/separado")
	String separarPedido(@PathVariable Long id) {

		pedidos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setSituacao(EnumSituacaoPedido.SEPARADO.getTipo());
		});

		return EnumSituacaoPedido.SEPARADO.getDescricao();
	}
	
	@PutMapping("pedidos/{id}/distribuido")
	String distribuirPedido(@PathVariable Long id) {
		
		pedidos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setSituacao(EnumSituacaoPedido.DISTRIBUIDO.getTipo());
		});
		
		return EnumSituacaoPedido.DISTRIBUIDO.getDescricao();
	}
	
	@PutMapping("pedidos/{id}/entregue")
	String entregarPedido(@PathVariable Long id) {
		
		pedidos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setSituacao(EnumSituacaoPedido.ENTREGUE.getTipo());
		});
		
		return EnumSituacaoPedido.ENTREGUE.getDescricao();
	}
	
	@PutMapping("pedidos/{id}/cancelado")
	String cancelarPedido(@PathVariable Long id) {
		
		pedidos.stream().filter(p -> p.getId().equals(id)).forEach(p -> {
			p.setSituacao(EnumSituacaoPedido.CANCELADO.getTipo());
		});
		
		return EnumSituacaoPedido.CANCELADO.getDescricao();
	}
	
	
}
