package fornecedores;

public class FornecedorJaInseridoException extends Exception {
	public FornecedorJaInseridoException() {
		super("Esse fornecedor já foi inserido.");
	}
}
