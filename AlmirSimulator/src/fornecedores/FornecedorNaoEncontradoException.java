package fornecedores;

public class FornecedorNaoEncontradoException extends Exception{
 public FornecedorNaoEncontradoException() {
	 super("Esse fornecedor n�o se encontra no sistema");
 }
}
