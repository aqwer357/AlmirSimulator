package fornecedores;

public interface RepositorioFornecedores {
	
	void inserir(Fornecedor fornecedor) ;
		
	
	
	void atualizar (Fornecedor fornecedor) ;
		
	
	void remover(int identificador) ;
		
	
	boolean existe(int identificador) ;
	

	Fornecedor procurar(int identificador) ;
		
	}
}
