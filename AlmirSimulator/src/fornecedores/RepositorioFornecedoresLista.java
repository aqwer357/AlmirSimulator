package fornecedores;

public class RepositorioFornecedoresLista implements RepositorioFornecedores {

	private Fornecedor fornecedor;
	private RepositorioFornecedoresLista proximo;

	// Construir lista
	public RepositorioFornecedoresLista() {
		this.fornecedor = null;
		this.proximo = null;
	}

	public void inserir(Fornecedor fornecedor) {
		if (this.fornecedor == null) {
			this.fornecedor = fornecedor;
			this.proximo = new RepositorioFornecedoresLista();
		} else {
			this.proximo.inserir(fornecedor);
		}
	}

	public boolean existe(int identificador) {
		if (this.fornecedor != null) {
			if (this.fornecedor.getIdentificador() == identificador) {
				return true;
			} else {
				return this.proximo.existe(identificador);
			}
		} else {
			return false;
		}
	}

	public void remover(int identificador) throws FornecedorNaoEncontradoException {
		if (existe(identificador)) {

			if (this.fornecedor != null) {
				if (this.fornecedor.getIdentificador() == identificador) {
					this.fornecedor = this.proximo.fornecedor;
					this.proximo = this.proximo.proximo;
				} else {
					this.proximo.remover(identificador);
				}
			}

		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		if (existe(fornecedor.getIdentificador()) == true) {

			if (this.fornecedor.getIdentificador() == fornecedor.getIdentificador()) {
				this.fornecedor = fornecedor;
			} else {
				this.proximo.atualizar(fornecedor);
			}

		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}
	}

	public Fornecedor procurar(int identificador) throws FornecedorNaoEncontradoException {

		Fornecedor retorno;
		retorno = null;

		if (existe(identificador)) {

			if (this.fornecedor != null) {
				if (this.fornecedor.getIdentificador() == identificador) {
					retorno = this.fornecedor;

				} else {
					this.proximo.procurar(identificador);
				}
			}

		} else {
			FornecedorNaoEncontradoException e;
			e = new FornecedorNaoEncontradoException();
			throw e;
		}
		return retorno;

	}
}
