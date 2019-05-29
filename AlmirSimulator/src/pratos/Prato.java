package pratos;

import ingredientes.Ingrediente;

public abstract class Prato {
	private int codigoPrato;
	private Ingrediente[] ingredientes;

	public Prato(int codigoPrato, Ingrediente[] ingredientes) {
		this.codigoPrato = codigoPrato;
		this.setIngredientes(ingredientes);
	}

	public int getCodigo() {
		return codigoPrato;
	}

	protected void setCodigo(int codigoPrato) {
		this.codigoPrato = codigoPrato;
	}

	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}
	
	public String printIngredientes() {
		String output = "";
		
		for (int i = 0; i < ingredientes.length; i++) {
			output += ingredientes[i].getNome() + "\n";
		}
		
		return output;
	}
	
	protected void setIngredientes(Ingrediente[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	abstract String getInformacoes();
	
}
