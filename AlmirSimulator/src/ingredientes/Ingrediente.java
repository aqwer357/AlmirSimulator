package ingredientes;

public class Ingrediente {
	private String nome;
	private boolean existe;
	private boolean especial;
	
	public Ingrediente(String nome, boolean especial) {
		this.nome = nome;
		this.especial = especial;
	}
	public String getNome() {
		return this.nome;
	}
	public boolean getTipo() {
		return this.especial;
	}
}

