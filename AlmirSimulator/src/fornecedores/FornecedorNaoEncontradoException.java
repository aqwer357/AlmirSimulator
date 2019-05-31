package fornecedores;

public class FornecedorNaoEncontradoException extends Exception{
 public FornecedorNaoEncontradoException() {
	 super("Esse fornecedor não se encontra no sistema");
 }
}
