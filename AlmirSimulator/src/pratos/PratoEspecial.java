package pratos;

import ingredientes.*;

public class PratoEspecial extends Prato {

	// PratoEspecial permite ao cliente inserir ingredientes especias no Prato.
	
	public PratoEspecial(int codigo, Ingrediente[] ingredientes) {
		super(codigo);
	}

	void inserirIngrediente(Ingrediente ingrediente) {
		this.getIngredientes().inserir(ingrediente);
	}

}
