package ingredientes;

public class IngredienteNaoEncontradoException extends Exception {
	public IngredienteNaoEncontradoException() {
		super("Ingrediente nao encontrado.");
	}
}
