package ingredientes;

public class RepositorioIngredientesArray {
	private Ingrediente[] ingredientes = new Ingrediente[1000];
	private int indice;

	public RepositorioIngredientesArray() {
		this.indice = 0;
	}

	public void inserir(Ingrediente ingrediente) {
		this.ingredientes[indice] = ingrediente;
		this.indice++;
	}

	public void atualizar(Ingrediente ingrediente) throws IngredienteNaoEncontradoException {
		Ingrediente ingredienteAlvo;
		if (existe(ingrediente.getNome())) {
			ingredienteAlvo = procurar(ingrediente.getNome());
			this.remover(ingredienteAlvo.getNome());
			this.inserir(ingrediente);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}

	public void remover(String nome) throws IngredienteNaoEncontradoException {
		Ingrediente aux;
		for (int i = 0; i < 1000; i++) {
			if (i < 999) {
				if (nome.contentEquals(ingredientes[i].getNome()) && ingredientes[i + 1] != null) {
					aux = ingredientes[i + 1];
					this.remover(ingredientes[i + 1].getNome());
					this.ingredientes[i] = aux;
				} else if (nome.contentEquals(ingredientes[i].getNome())) {
					this.ingredientes[i] = null;
					this.indice--;
					i = 1000;
				}
			} else {
				this.indice--;
				this.ingredientes[i] = null;
			}
		}
	}

	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException {
		int aux = 0;
		for (int i = 0; i < 1000; i++) {
			if (ingredientes[i] != null) {
				if (ingredientes[i].getNome().contentEquals(nome)) {
					aux = i;
					i = 1000;
				} 
			} else {
				throw new IngredienteNaoEncontradoException();
			}
		}
		return this.ingredientes[aux];
	}

	public boolean existe(String nome) {
		boolean existe = false;
		for (int i = 0; i < 1000; i++) {
			if (ingredientes[i] != null) {
				if (ingredientes[i].getNome().contentEquals(nome)) {
					i = 1000;
					existe = true;
				}
			} else {
				existe = false;
			}
		}
		return existe;
	}
}
