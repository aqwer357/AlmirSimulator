package fornecedores;

public interface RepositorioFornecedores {
	
	void inserir(Fornecedor fornecedor);
	
	void atualizar (Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
		
	
	void remover(int identificador) throws FornecedorNaoEncontradoException;
		
	
	boolean existe(int identificador) ;
	

	Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException;
		
	}
}
