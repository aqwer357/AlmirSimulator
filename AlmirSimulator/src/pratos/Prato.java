package pratos;

import ingredientes.*;

public abstract class Prato {
	private String nome;
	private RepositorioIngredientes ingredientes;

	public Prato(String nome) {
		this.nome = nome;
		this.ingredientes = new RepositorioIngredientesLista();
		
	}

	public RepositorioIngredientes getIngredientes() {
		return ingredientes;
	}

	abstract void inserirIngrediente(Ingrediente ingrediente) throws IIException;

	protected void setIngredientes(RepositorioIngredientes ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

}