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
		this.pedidos = new CadastroPedidos(pedidos, ingredientes);
		this.pratos = new CadastroPratos(pratos);
		this.clientes = new CadastroClientes(clientes);
	
	}

	// FORNECEDOR
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException {
		this.fornecedores.cadastrar(fornecedor);
	}

	public void removerFornecedor(int identificador) throws FornecedorNaoEncontradoException {
		this.fornecedores.remover(identificador);
	}

	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.fornecedores.atualizar(fornecedor);
	}

	public boolean existeFornecedor(int identificador) {
		return this.fornecedores.existe(identificador);
	}

	public Fornecedor procurarFornecedor(int identificador) throws FornecedorNaoEncontradoException {
		return this.fornecedores.procurar(identificador);
	}
	
	//PEDIDOS
	public void cadastrarPedidos(Pedido pedido) throws IngredienteNaoEncontradoException {
		this.pedidos.cadastrarPedido(pedido);
	}
	
	public void removerPedido(Cliente cliente) throws ClienteNaoEncontradoException{
		this.pedidos.removerPedido(cliente);
	}
	
	public Pedido obterPedido(Cliente cliente) throws ClienteNaoEncontradoException{
		return this.pedidos.obterPedido(cliente);
	}
	
	public void atualizarPedido(Cliente cliente, Pedido novoPedido) throws ClienteNaoEncontradoException{
		this.pedidos.atualizarPedido(cliente, novoPedido);
	}
	
	public boolean existePedido(Cliente cliente) {
		return this.pedidos.existePedido(cliente);
	}
	
	//PRATOS
	public void cadastrarPrato(Prato prato) throws PJFIException {
		this.pratos.inserir(prato);
	}
		
	public void removerPrato(int codigoPrato) throws PNEException {
		this.pratos.remover(codigoPrato);
	}
		
	public Prato obterPrato(int codigoPrato) throws PNEException {
		return this.pratos.procurar(codigoPrato);
	}
		
	public void atualizarPratos(Prato prato) throws PNEException {
		this.pratos.atualizar(prato);
	}
		
	public boolean existePratos(int codigoPrato) {
		return this.pratos.existe(codigoPrato);
	}


	//O monitor disse q estamos fazendo a fachada do jeito certo, dai eh so seguir o modelo. Beijao, galera! ~Thay 	
	
	// CHARLES NA HORA DE TU FAZER A TUA PARTE DA FACHADA FAZ O SEGUINTE:
	// QUANDO TU INSERIR, TU PEGA INGREDIENTE DO REPOSITORIO DE FORNECEDOR
	// SE NAO TIVER, CRIA UM ERRO
	// SE TIVER, APAGA O INGREDIENTE DO REPOSITORIO DE FORNECEDOR E ADICIONA NO TEU
	// FOFO UwU
}
