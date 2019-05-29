package ingredientes;

public class RepositorioIngredientesLista implements RepositorioIngredientes {
	private Ingrediente ingrediente;
	private RepositorioIngredientesLista proximo;
	
	public RepositorioIngredientesLista() {
		this.ingrediente = null;
		this.proximo= null;
	}
	
	public void inserir(Ingrediente ingrediente) {
		if (this.ingrediente == null) {
			this.ingrediente = ingrediente;
			this.proximo = new RepositorioIngredientesLista();
		} else {
			proximo.inserir(ingrediente);
		}
	}
	
	public void atualizar(Ingrediente ingrediente) {
		Ingrediente ingredienteAlvo;
		ingredienteAlvo = procurar(ingrediente.getNome());
		this.remover(ingredienteAlvo.getNome());
		this.inserir(ingrediente);
		
	}
	
	public void remover(String nome) {
		if (this.ingrediente != null) {
			if (this.ingrediente.getNome().contentEquals(nome)) {
				this.ingrediente = this.proximo.ingrediente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new RuntimeException("Erro");
		}
	}
	
	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException {
		if (this.ingrediente != null) {
			if (this.ingrediente.getNome().contentEquals(nome)) {
				return this.ingrediente;
			} else {
				return proximo.procurar(nome);
			}
		} else {
			throw new IngredienteNaoEncontradoException;
		}
	}
	
	public boolean existe(String nome) {
		if (this.ingrediente != null) {
			if (this.ingrediente.getNome().contentEquals(nome)) {
				return true;
			} else {
				return proximo.existe(nome);
			}
		} else {
			throw new RuntimeException("Erro");
		}
	}
}
