package ingredientes;

public class CadastroIngredientes {
	private RepositorioIngredientes ingredientes;
	
	public CadastroIngredientes (RepositorioIngredientes ingredientes) {
		
		this.ingredientes = ingredientes;
	
	}
	
	public void cadastrar(Ingrediente Ingrediente) throws IngredienteJaCadastradoException {
		if(this.ingredientes.existe(Ingrediente.getNome())) {
			throw new IngredienteJaCadastradoException();
		}else {
			this.ingredientes.inserir(Ingrediente);
		}
	}
	
	public void remover(String nome) throws IngredienteNaoEncontradoException {
		if (existe(nome)) {
			this.ingredientes.remover(nome);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
	
	public void atualizar(Ingrediente Ingrediente) throws IngredienteNaoEncontradoException {
		if (existe(Ingrediente.getNome())) {
			this.ingredientes.atualizar(Ingrediente);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
	
	public boolean existe(String nome) {
        return this.ingredientes.existe(nome);
    }
	
	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException {
		if (existe(nome)) {
			return this.ingredientes.procurar(nome);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
}
