package pratos;

import ingredientes.*;

public class PratoComum extends Prato {

	public PratoComum(String nome) {
		super(nome);
	}

	public void inserirIngrediente(Ingrediente ingrediente) throws IIException {
		// Se o ingrediente for especial, nao pode ser inserido.

		if (ingrediente.getTipo())
			throw new IIException();
		else
			this.getIngredientes().inserir(ingrediente);
	}

}
