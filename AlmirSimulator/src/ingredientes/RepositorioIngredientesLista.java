package ingredientes;

public class RepositorioIngredientesLista implements RepositorioIngredientes {
	private Ingrediente ingrediente;
	private RepositorioIngredientesLista proximo;
	
	public RepositorioIngredientesLista() {
		this.ingrediente = null;
		this.proximo= null;
	}
	
	public void inserir(Ingrediente ingrediente) throws IngredienteJaExisteException {
		if (this.ingrediente == null) {
			this.ingrediente = ingrediente;
			this.proximo = new RepositorioIngredientesLista();
		} else {
			if (this.ingrediente.getNome() != ingrediente.getNome()) {
				proximo.inserir(ingrediente);
			} else {
				throw new IngredienteJaExisteException();
			}
		}
	}
	
	public void atualizar(Ingrediente ingrediente) throws IngredienteNaoEncontradoException, IngredienteJaExisteException {
		Ingrediente ingredienteAlvo;
		if (existe(ingrediente.getNome())) {
			ingredienteAlvo = procurar(ingrediente.getNome());
			this.remover(ingredienteAlvo.getNome());
			this.inserir(ingrediente);
		}
	}
	
	public void remover(String nome) throws IngredienteNaoEncontradoException {
		if (this.ingrediente != null) {
			if (this.ingrediente.getNome().contentEquals(nome)) {
				this.ingrediente = this.proximo.ingrediente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new IngredienteNaoEncontradoException();
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
			throw new IngredienteNaoEncontradoException();
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
			return false;
		}
	}
}
