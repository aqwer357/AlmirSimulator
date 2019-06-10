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

//import pedidos.Pedido;
//inicializar um atributo do tipo pedidos, pois junto ao pedido virah um objeto do tipo cliente com todos os dados necess�rios referente ao prato.
//by monitor.