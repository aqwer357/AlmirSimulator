package ingredientes;

public class CadastroIngredientes {
	private RepositorioIngredientes ingrediente;
	
	public CadastroIngredientes (RepositorioIngredientes ingrediente) {
		
		this.ingrediente = ingrediente;
	
	}
	
	public void cadastrar(Ingrediente Ingrediente) throws IngredienteJaCadastradoException {
		if(this.ingrediente.existe(Ingrediente.getNome())) {
			throw new IngredienteJaCadastradoException();
		}else {
			this.ingrediente.inserir(Ingrediente);
		}
	}
	
	public void remover(String nome) throws IngredienteNaoEncontradoException {
		if (existe(nome)) {
			this.ingrediente.remover(nome);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
	
	public void atualizar(Ingrediente Ingrediente) throws IngredienteNaoEncontradoException {
		if (existe(Ingrediente.getNome())) {
			this.ingrediente.atualizar(Ingrediente);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
	
	public boolean existe(String identificador) {
        return this.ingrediente.existe(identificador);
    }
	
	public Ingrediente procurar(String nome) throws IngredienteNaoEncontradoException {
		if (existe(nome)) {
			return this.ingrediente.procurar(nome);
		} else {
			throw new IngredienteNaoEncontradoException();
		}
	}
}