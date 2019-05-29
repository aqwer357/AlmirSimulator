package ingredientes;

public interface RepositorioIngredientes {
	public void inserir(Ingrediente ingrediente)
		throws IngredienteJaExisteException;
	
	public void atualizar(Ingrediente ingrediente) 
		throws IngredienteNaoEncontradoException, IngredienteJaExisteException;
	
	public void remover(String nome) 
		throws IngredienteNaoEncontradoException;
	
	public Ingrediente procurar(String nome) 
		throws IngredienteNaoEncontradoException;
	
	public boolean existe(String nome);
	
}
