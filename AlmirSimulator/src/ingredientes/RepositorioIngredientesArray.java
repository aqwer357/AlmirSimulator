package ingredientes;

public class RepositorioIngredientesArray {
	private Ingrediente[] ingredientes = new Ingrediente[1000];
	private int indice;
	
	public RepositorioIngredientesArray() {
		this.indice = 0;
	}
	
	public void inserir(Ingrediente ingrediente) throws IngredienteJaExisteException  {
		if (existe(ingrediente.getNome())) {
			throw new IngredienteJaExisteException();
		} else {
			this.ingredientes[indice] = ingrediente;
			indice++;
			
		}
	}
	
	public void atualizar() throws IngredienteNaoEncontradoException, IngredienteJaExisteException {
		
	}
	
	public void remover(String nome) throws IngredienteNaoEncontradoException {
		
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
