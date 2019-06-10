package fachada;

import fornecedores.*;
import ingredientes.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import clientes.*;

// bom dia gruslo
//charles 
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
		this.pedidos = new CadastroPedidos(pedidos, ingredientes); //Envia os dois repositorios inicializados p a classe pedidos;
		this.pratos = new CadastroPratos(pratos);
		this.clientes = new CadastroClientes(clientes);
	
	}

	// FORNECEDOR & INGREDIENTE
	
	// Só cadastramos os ingredientes que um fornecedor fornece
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException, IngredienteJaCadastradoException {
		this.fornecedores.cadastrar(fornecedor);
		
		RepositorioIngredientesArray ingredientesNovos = fornecedor.getIngredientes();
		
		for(int i=0; i<= ingredientesNovos.getIndice(); i++) {
			
			this.ingredientes.cadastrar(ingredientesNovos.getAtIndex(i));
		}
		
	}
	// Removemos o fornecedor e seus ingredientes
	public void removerFornecedor(int identificador) throws FornecedorNaoEncontradoException, IngredienteNaoEncontradoException {
		this.fornecedores.remover(identificador);
		
		Fornecedor fornecedorRemovido = fornecedores.procurar(identificador);
		
		RepositorioIngredientesArray ingredientesRemovidos = fornecedorRemovido.getIngredientes();
	
		for(int i=0; i<= ingredientesRemovidos.getIndice(); i++) {
			
			this.ingredientes.remover(ingredientesRemovidos.getAtIndex(i).getNome());
		}
		
	}
	//Atualiza as informações do fornecedor
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, IngredienteNaoEncontradoException {
		this.fornecedores.atualizar(fornecedor);
		
		RepositorioIngredientesArray ingredientesAtualizados = fornecedor.getIngredientes();
		
		for(int i=0; i<= ingredientesAtualizados.getIndice();i++) {
			this.ingredientes.atualizar(ingredientesAtualizados.getAtIndex(i));
		}
	}

	public boolean existeFornecedor(int identificador) {
		return this.fornecedores.existe(identificador);
	}

	public Fornecedor procurarFornecedor(int identificador) throws FornecedorNaoEncontradoException {
		return this.fornecedores.procurar(identificador);
	}
	
	public boolean existeIngrediente(String nome) {
		return this.ingredientes.existe(nome);
	}
	
	public Ingrediente procurarIngrediente(String nome) throws IngredienteNaoEncontradoException {
		return this.ingredientes.procurar(nome);
	}
	
	//PRATOS
	public void cadastrarPrato(Prato prato, Pedido pedido, RepositorioIngredientes ingredientes) throws PJFIException, IIException, IngredienteNaoEncontradoException {
		this.pratos.inserir(prato, pedido, ingredientes);
	}
			
	public void removerPrato(String nome) throws PNEException {
		this.pratos.remover(nome);
	}
		
	public Prato obterPrato(String nome) throws PNEException {
		return this.pratos.procurar(nome);
	}
		
	public void atualizarPratos(Prato prato) throws PNEException {
		this.pratos.atualizar(prato);
	}
		
	public boolean existePratos(String nome) {
		return this.pratos.existe(nome);
	}
	
	// CLIENTES
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException,LimiteAtingidoException{
		this.clientes.cadastrar(cliente);
	}
	
	public void removerCliente(String nome) throws ClienteNaoEncontradoException{
		this.clientes.remover(nome);
	}
	
	public Cliente procurarCliente(String nome) throws ClienteNaoEncontradoException{
		return this.clientes.procurar(nome);
	}
	
	public void atualizarClientes(Cliente cliente) throws ClienteNaoEncontradoException{
		this.clientes.atualizar(cliente);
	}
	
	public boolean existeCliente(String nome) {
		return this.clientes.existe(nome);
	}


	//O monitor disse q estamos fazendo a fachada do jeito certo, dai eh so seguir o modelo. Beijao, galera! ~Thay 	
	
	// CHARLES NA HORA DE TU FAZER A TUA PARTE DA FACHADA FAZ O SEGUINTE:
	// QUANDO TU INSERIR, TU PEGA INGREDIENTE DO REPOSITORIO DE FORNECEDOR
	// SE NAO TIVER, CRIA UM ERRO
	// SE TIVER, APAGA O INGREDIENTE DO REPOSITORIO DE FORNECEDOR E ADICIONA NO TEU
	// FOFO UwU
}
