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
	
	public Almir(RepositorioFornecedores repositorio) {
		this.fornecedores = new CadastroFornecedores(repositorio);
	}
	
	public Almir(RepositorioIngredientes repositorio) {
		this.ingredientes = new CadastroIngredientes(repositorio);
	}
	
	public Almir(RepositorioPedidos repositorio) {
		this.pedidos = new CadastroPedidos(repositorio);
	}
	
	public Almir(RepositorioPratos repositorio) {
		this.pratos = new CadastroPratos(repositorio);
	}
	
	//fornecedor
	
	public void cadastrarFornecedor(Fornecedor fornecedor) 
			throws FornecedorJaCadastradoException {
		
		if(this.fornecedores.existe(fornecedor.getIdentificador())) {
			FornecedorJaCadastradoException e;
			e = new FornecedorJaCadastradoException();
			throw e;
			
		}else {
			this.fornecedores.cadastrar(fornecedor);
		}
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
	
	// CHARLES NA HORA DE TU FAZER A TUA PARTE DA FACHADA FAZ O SEGUINTE:
	// QUANDO TU INSERIR, TU PEGA INGREDIENTE DO REPOSITORIO DE FORNECEDOR
	// SE NAO TIVER, CRIA UM ERRO
	// SE TIVER, APAGA O INGREDIENTE DO REPOSITORIO DE FORNECEDOR E ADICIONA NO TEU
	// FOFO UwU
}
