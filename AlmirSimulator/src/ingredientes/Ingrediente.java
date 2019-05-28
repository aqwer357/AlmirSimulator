package ingredientes;

public class Ingrediente {
	private String nome;
	private int qtd;
	
	Ingrediente(String nome, int qtd) {
		this.nome = nome;
		this.qtd = qtd;
	}
	public String getNome() {
		return this.nome;
	}
	public int getQtd() {
		return this.qtd;
	}
}

