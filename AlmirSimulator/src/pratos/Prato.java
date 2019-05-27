package pratos;

public abstract class Prato {
	private int codigo;
	private String nome;

	public Prato(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public abstract 
}
