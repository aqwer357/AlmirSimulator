package ingredientes;

public interface RepositorioIngredientes {
	public void inserir(Ingrediente ingrediente);
	
	public void atualizar(Ingrediente ingrediente) 
		throws IngredienteNaoEncontradoException;
	
	public void remover(String nome) 
		throws IngredienteNaoEncontradoException;
	
	public Ingrediente procurar(String nome) 
		throws IngredienteNaoEncontradoException;
	
	public boolean existe(String nome) 
		throws IngredienteNaoEncontradoException;
	
}
