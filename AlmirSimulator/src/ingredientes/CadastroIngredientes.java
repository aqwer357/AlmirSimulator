package ingredientes;

public class CadastroIngredientes {
	private RepositorioIngredientes ingrediente;
	
	public CadastroIngredientes (RepositorioIngredientes ingrediente) {
		
	this.ingrediente = ingrediente;
	
	}
	
	public void cadastrar(Ingrediente Ingrediente) throws IngredienteJaCadastradoException {
		if(this.ingrediente.existe(Ingrediente.getNome())) {
			IngredienteJaCadastradoException e;
			e = new IngredienteJaCadastradoException();
			throw e;
		}else {
			this.ingrediente.inserir(Ingrediente);
		}
	}
	
	public void remover(String identificador) throws IngredienteNaoEncontradoException{
		this.ingrediente.remover(identificador);
	}
	
	public void atualizar(Ingrediente Ingrediente) throws IngredienteNaoEncontradoException {
		this.ingrediente.atualizar(Ingrediente);
	}
	
	public boolean existe(String identificador) {
        return this.ingrediente.existe(identificador);
    }
	
	public Ingrediente procurar(String identificador) throws IngredienteNaoEncontradoException{
		return this.ingrediente.procurar(identificador);
	}
}