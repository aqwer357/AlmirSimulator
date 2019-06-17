package fornecedores;

import ingredientes.*;

public class Fornecedor {
	private String nome;
	private RepositorioIngredientesArray ingredientes;
	private int identificador;

	public Fornecedor(String nome, RepositorioIngredientesArray ingredientes, int identificador) {
		this.nome = nome;

		this.ingredientes = ingredientes;

		this.identificador = identificador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIngredientes(RepositorioIngredientesArray ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return this.nome;
	}

	public Ingrediente[] getIngredientes() {
		return this.ingredientes.getInterator();
	}
	
	public int tamanhoArray() {
		return this.ingredientes.getIndice();
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
