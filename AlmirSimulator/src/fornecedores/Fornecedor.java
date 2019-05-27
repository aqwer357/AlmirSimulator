package fornecedores;

public class Fornecedor {
	private String nome;
	private RepositoriosIngredientesArray ingredientes;
	private int identificador;
	
	public Fornecedor(String nome, RepositoriosIngredientesArray ingredientes, int identificador) {
		this.nome = nome;
		this.ingredientes =ingredientes;
		this.identificador = identificador;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Ingrediente getIngrediente() {
		return this.ingrediente;
	}
	public int getIdentificador() {
		return this.identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
