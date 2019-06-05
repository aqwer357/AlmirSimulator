package ingredientes;

public class Ingrediente {
	private String nome;
	private boolean existe;
	private boolean tipo;
	
	Ingrediente(String nome, boolean existe, boolean tipo) {
		this.nome = nome;
		this.existe = existe;
		this.tipo = tipo;
	}
	public String getNome() {
		return this.nome;
	}
	public boolean getExiste() {
		return this.existe;
	}
	public boolean getTipo() {
		return this.tipo;
	}
}

