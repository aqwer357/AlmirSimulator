package pratos;

import ingredientes.Ingrediente;

public class PratoComum extends Prato {

	public PratoComum(int codigoPrato, Ingrediente[] ingredientes) {
		super(codigoPrato, ingredientes);
	}
	
	public String getInformacoes() {
		String output = "";
		output += "Codigo: " + this.getCodigo() + "\nIngredientes: " + this.printIngredientes();
		
		return output;
	}
	
}
