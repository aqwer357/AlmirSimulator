package ingredientes;

public class IngredienteJaExisteException extends Exception {
	public IngredienteJaExisteException() {
		super("Ingrediente já existe.");
	}
}
