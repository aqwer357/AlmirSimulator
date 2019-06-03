package fornecedores;

public class CadastroFornecedores {
	private RepositorioFornecedores repositorio;
	
	public CadastroFornecedores (boolean tipo) {
		if(tipo) {
			repositorio = new RepositorioFornecedoresLista();
		}else {
			repositorio = new RepositorioFornecedoresArray();
		}
	}
	public void cadastrar(Fornecedor fornecedor) throws FornecedorJaCadastradoException {
		if(this.repositorio.existe(fornecedor.getIdentificador())) {
			FornecedorJaCadastradoException e;
			e = new FornecedorJaCadastradoException();
			throw e;
		}else {
			this.repositorio.inserir(fornecedor);
		}
	}
	
	public void remover(int identificador) throws FornecedorNaoEncontradoException{
		this.repositorio.remover(identificador);
	}
	
	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.repositorio.atualizar(fornecedor);
	}
	
	public boolean existe(int identificador) {
        return this.repositorio.existe(identificador);
    }
	
	public Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException{
		return this.repositorio.procurar(identificador);
	}
}
