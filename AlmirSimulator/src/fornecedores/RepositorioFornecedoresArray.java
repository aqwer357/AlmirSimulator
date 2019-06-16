package fornecedores;

public class RepositorioFornecedoresArray implements RepositorioFornecedores {
	private Fornecedor[] fornecedores;
	private int indice;

	// construtor basico
	public RepositorioFornecedoresArray() {
		this.fornecedores = new Fornecedor[20];
		this.indice = 0;
	}
	
	public int getIndice(int identificador) {
		int indice = 0;
		
		for(int i = indice; i<this.indice;i++) {
			
			if(fornecedores[i].getIdentificador() == identificador) {
				indice = i;
				i = this.indice;
			}
		}
		
		return indice;
	}

	// simulando um array dinamico para nao limitar o tamanho da array ao inserir

	public void inserir(Fornecedor fornecedor) {
		if (this.indice < this.fornecedores.length) {
			this.fornecedores[indice] = fornecedor;
			this.indice = this.indice + 1;

		} else {

			Fornecedor[] aux = new Fornecedor[2 * fornecedores.length];

			for (int i = 0; i < fornecedores.length; i++) {
				aux[i] = this.fornecedores[i];
			}
			fornecedores = aux;
			this.fornecedores[indice] = fornecedor;
			this.indice = this.indice + 1;
		}

	}

	public boolean existe(int identificador) {

		for (int i = 0; i < this.indice; i++) {

			if (fornecedores[i].getIdentificador() == identificador) {
				return true;
			}

		}

		return false;
	}

	public void remover(int identificador) throws FornecedorNaoEncontradoException {

		if (this.existe(identificador)) {
			
			int i = this.getIndice(identificador);
			this.indice = this.indice - 1;

			this.fornecedores[i] = this.fornecedores[this.indice];
			this.fornecedores[this.indice] = null;
			
		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}

	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {

		if (this.existe(fornecedor.getIdentificador())) {

			int i = this.getIndice(fornecedor.getIdentificador());
			
			this.fornecedores[i] = fornecedor;
			
		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}
	}

	public Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException {

		if (this.existe(identificador)) {
			
			int i = this.getIndice(identificador);
			Fornecedor retorno = null;

			retorno = this.fornecedores[i];
			return retorno;

		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}
	}

}
