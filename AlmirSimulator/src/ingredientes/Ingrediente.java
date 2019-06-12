package ingredientes;

public class Ingrediente {
	private String nome;
	private boolean existe;
	private boolean especial;
	
	public Ingrediente(String nome, boolean existe, boolean especial) {
		this.nome = nome;
		this.existe = existe;
		this.especial = especial;
	}
	public String getNome() {
		return this.nome;
	}
	public boolean getExiste() {
		return this.existe;
	}
	public boolean getTipo() {
		return this.especial;
	}
}

