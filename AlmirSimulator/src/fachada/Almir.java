package fachada;

import fornecedores.*;
import ingredientes.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;

// bom dia gruslo

// to me baseando em https://github.com/joaovaladares/CinDex/blob/master/CinDex/src/fachada/CinDex.java
// pq facilita pra todo mundo kk


public class Almir {
	private CadastroFornecedores fornecedores;
	private CadastroIngredientes ingredientes;
	private CadastroPedidos pedidos;
	private CadastroPratos pratos;

	// o booleano tipo decide se é lista ou array
	// ignora a ideia de cima, sergio falou q era má ideia
	// to fazendo como ele recomendou

	public Almir(RepositorioFornecedores fornecedores, RepositorioIngredientes ingredientes, RepositorioPedidos pedidos, RepositorioPratos pratos) {
		this.fornecedores = new CadastroFornecedores(fornecedores);
		this.ingredientes = new CadastroIngredientes(ingredientes);
		this.pedidos = new CadastroPedidos(pedidos);
		this.pratos = new CadastroPratos(pratos);
	}

	//fornecedor

	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException {
		this.fornecedores.cadastrar(fornecedor);
	}

	public void remover(int identificador) throws FornecedorNaoEncontradoException{
		this.fornecedores.remover(identificador);
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.fornecedores.atualizar(fornecedor);
	}

	public boolean existe(int identificador) {
		return this.fornecedores.existe(identificador);
	}

	public Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException{
		return this.fornecedores.procurar(identificador);
	}

	// A partir daqui: ingredientes

	public void cadastrarIngrediente(Ingrediente ingrediente) throws IngredienteJaCadastradoException {
		this.ingredientes.cadastrar(ingrediente);
	}

	public void remover(String nome) throws IngredienteNaoEncontradoException{
		this.ingredientes.remover(nome);
	}

	public void atualizar(Ingrediente ingrediente) throws IngredienteNaoEncontradoException {
		this.ingredientes.atualizar(ingrediente);
	}

	public boolean existe(String nome) {
		return this.ingredientes.existe(nome);
	}

	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException{
		return this.ingredientes.procurar(nome);
	}

	// CHARLES NA HORA DE TU FAZER A TUA PARTE DA FACHADA FAZ O SEGUINTE:
	// QUANDO TU INSERIR, TU PEGA INGREDIENTE DO REPOSITORIO DE FORNECEDOR
	// SE NAO TIVER, CRIA UM ERRO
	// SE TIVER, APAGA O INGREDIENTE DO REPOSITORIO DE FORNECEDOR E ADICIONA NO TEU
	// FOFO UwU
}
