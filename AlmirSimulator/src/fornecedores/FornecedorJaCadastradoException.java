package fornecedores;

public class FornecedorJaCadastradoException extends Exception {
	public FornecedorJaCadastradoException() {
		super("Esse fornecedor já foi inserido.");
	}
}
