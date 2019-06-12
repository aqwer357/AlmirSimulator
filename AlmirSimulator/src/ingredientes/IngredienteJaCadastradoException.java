package ingredientes;

public class IngredienteJaCadastradoException extends Exception{
	public IngredienteJaCadastradoException() {
		super("Ingrediente ja existe.");
	}
}
