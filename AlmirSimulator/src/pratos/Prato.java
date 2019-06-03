package pratos;

import ingredientes.*;

public abstract class Prato {
	private int codigo;
	private RepositorioIngredientes ingredientes;

	public Prato(int codigoPrato) {
		this.codigo = codigoPrato;
		this.ingredientes = new RepositorioIngredientesLista();
	}

	public int getCodigo() {
		return codigo;
	}

	protected void setCodigo(int codigoPrato) {
		this.codigo = codigoPrato;
	}

	public RepositorioIngredientes getIngredientes() {
		return ingredientes;
	}
	
	abstract void inserirIngrediente(Ingrediente ingrediente) throws IIException;

	protected void setIngredientes(RepositorioIngredientes ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
