package fornecedores;
import ingredientes.*;
public class Fornecedor {
	private String nome;
	private RepositorioIngredientes ingredientes;
	private int identificador;
	String tipo;
	public Fornecedor(String nome, RepositorioIngredientes ingredientes, int identificador, String tipo) {
		this.nome = nome;
		if(tipo.equals("array")) {
			this.ingredientes = new RepositorioIngredientesArray();
		}
		else {
			this.ingredientes = new RepositorioIngredientesLista();
		}
		this.identificador = identificador;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIngredientes(RepositorioIngredientes ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public RepositorioIngredientes getIngredientes() {
		return this.ingredientes;
	}
	public int getIdentificador() {
		return this.identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
