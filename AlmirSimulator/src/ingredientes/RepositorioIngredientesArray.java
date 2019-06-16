package ingredientes;

public class RepositorioIngredientesArray implements RepositorioIngredientes {
	private Ingrediente[] ingredientes;
	private int indice;

	public RepositorioIngredientesArray() {
		this.ingredientes = new Ingrediente[1000];
		this.indice = 0;
	}

	public void inserir(Ingrediente ingrediente) {
		this.ingredientes[indice] = ingrediente;
		this.indice++;
	}
	
	public Ingrediente getAtIndex(int index) {
		return ingredientes[index];
	}
	
	public int getIndice() {
		return this.indice;
	}
	public int getIndiceOf(String nome) {
		int indice = 0;
		
		for(int i=0;i<this.indice;i++) {
			if(this.ingredientes[i].getNome().contentEquals(nome)) {
				indice = i;
				i = this.indice;
			}
		}
		return indice;
	}

	public void atualizar(Ingrediente ingrediente) throws IngredienteNaoEncontradoException {
		if(this.existe(ingrediente.getNome())) {
			
			int i = this.getIndiceOf(ingrediente.getNome());
			this.ingredientes[i] = ingrediente;
			
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}

	public void remover(String nome) throws IngredienteNaoEncontradoException {
	if(this.existe(nome)) {
		
		int i = this.getIndiceOf(nome);
		this.indice = this.indice -1;
		
		this.ingredientes[i] = this.ingredientes[this.indice];
		this.ingredientes[this.indice] = null;
		
	} else {
		throw new IngredienteNaoEncontradoException();
	}
	}

	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException {
		if(this.existe(nome)) {
			
			int i = this.getIndiceOf(nome);
			Ingrediente retorno = null;
			retorno = this.ingredientes[i];
			
			return retorno;
			
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}

	public boolean existe(String nome) {
		
		for (int i = 0; i < this.indice; i++) {
			
			if (ingredientes[i].getNome().contentEquals(nome)) {
			return true;
			}
	   }
		return false;
	}
}

