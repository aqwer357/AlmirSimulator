package clientes;

public interface RepositorioClientes {

	boolean existe(String nome);
	Cliente procurar(String nome) throws ClienteNaoEncontradoException;
	void inserir(Cliente cliente) throws LimiteAtingidoException;
	void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	void remover(String nome) throws ClienteNaoEncontradoException;
	
}
