package fachada;

import fornecedores.*;
import ingredientes.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import clientes.*;

// bom dia gruslo

// to me baseando em https://github.com/joaovaladares/CinDex/blob/master/CinDex/src/fachada/CinDex.java
// pq facilita pra todo mundo kk

public class Almir {
	private CadastroFornecedores fornecedores;
	private CadastroIngredientes ingredientes;
	private CadastroPedidos pedidos;
	private CadastroPratos pratos;
	private CadastroClientes clientes;

	// Sergio disse que a decisao do repositorio eh feita no main, portanto
	// deveremos trabalhar como se isso ja tivesse sido decidido.

	public Almir(RepositorioFornecedores fornecedores, RepositorioIngredientes ingredientes, RepositorioPedidos pedidos,
			RepositorioPratos pratos, RepositorioCliente clientes) {  //Indica o tipo do repositorio a ser usado;
		
		this.fornecedores = new CadastroFornecedores(fornecedores); //inicializa os repositorios
		this.ingredientes = new CadastroIngredientes(ingredientes);
		this.pedidos = new CadastroPedidos(pedidos);
		this.pratos = new CadastroPratos(pratos);
		this.clientes = new CadastroClientes(clientes);
	
	}

	// FORNECEDOR
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException {
		this.fornecedores.cadastrar(fornecedor);
	}

	public void remover(int identificador) throws FornecedorNaoEncontradoException {
		this.fornecedores.remover(identificador);
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.fornecedores.atualizar(fornecedor);
	}

	public boolean existe(int identificador) {
		return this.fornecedores.existe(identificador);
	}

	public Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException {
		return this.fornecedores.procurar(identificador);
	}
	
	//PEDIDOS
	public void cadastrarPedidos(Pedido pedido) {
		this.pedidos.inserir(pedido);
	}
	
	public void removerPedido(Cliente cliente) throws ClienteNaoEncontradoException{
		this.pedidos.remover(cliente);
	}
	
	public Pedido obterPedido(Cliente cliente) throws ClienteNaoEncontradoException{
		return this.pedidos.obterPedido(cliente);
	}
	
	public void atualizarPedido(Cliente cliente, Pedido novoPedido) throws ClienteNaoEncontradoException{
		this.pedidos.atualizarPedido(cliente, novoPedido);
	}
	
	public boolean existePedido(Cliente cliente) {
		return this.pedidos.existe(cliente);
	}

	//O monitor disse q estamos fazendo a fachada do jeito certo, dai eh so seguir o modelo. Beijao, galera! ~Thay 	
	
	// CHARLES NA HORA DE TU FAZER A TUA PARTE DA FACHADA FAZ O SEGUINTE:
	// QUANDO TU INSERIR, TU PEGA INGREDIENTE DO REPOSITORIO DE FORNECEDOR
	// SE NAO TIVER, CRIA UM ERRO
	// SE TIVER, APAGA O INGREDIENTE DO REPOSITORIO DE FORNECEDOR E ADICIONA NO TEU
	// FOFO UwU
}
