package clientes;

public class CadastroClientes {
	private RepositorioCliente repositorio;
	
	public CadastroClientes(RepositorioCliente repositorio) {
		
	this.repositorio = repositorio;
	
	}
	
	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException , LimiteAtingidoException{
		if(this.repositorio.existe(cliente.getNome())) {
			throw new ClienteJaCadastradoException();
		}else {
			this.repositorio.inserir(cliente);
		}
	}
	
	public void remover(String nome) throws ClienteNaoEncontradoException{
		this.repositorio.remover(nome);
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		this.repositorio.atualizar(cliente);
	}
	
	public boolean existe(String nome) {
        return this.repositorio.existe(nome);
    }
	
	public Cliente procurar(String nome) throws ClienteNaoEncontradoException{
		return this.repositorio.procurar(nome);
	}
}

