package pratos;

import ingredientes.*;

public class PratoEspecial extends Prato {

	public PratoEspecial(String nome) {
		super(nome);
	}

	// PratoEspecial permite ao cliente inserir ingredientes especias no Prato.

	void inserirIngrediente(Ingrediente ingrediente) {
		this.getIngredientes().inserir(ingrediente);
	}

}
