package fornecedores;

public class FornecedorNaoEncontradoException extends Exception {
	public FornecedorNaoEncontradoException() {
		super("Esse fornecedor nao se encontra no sistema.");
	}
}
