package pratos;

import ingredientes.Ingrediente;

public abstract class Prato {
	private int codigo;
	private Ingrediente[] ingredientes;

	public Prato(int codigo, Ingrediente[] ingredientes) {
		this.codigo = codigo;
		this.setIngredientes(ingredientes);
	}

	public int getCodigo() {
		return codigo;
	}

	protected void setCodigo(int codigo) {
		this.codigo = codigo;
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
