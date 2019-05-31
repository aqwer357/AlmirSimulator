package clientes;

public interface RepositorioCliente {

	boolean existe(String nome) throws ClienteNaoEncontradoException;
	Cliente procurar(String nome);
	void inserir(Cliente cliente) throws LimiteAtingidoException;
	void atualizar(Cliente cliente);
	void remover(String nome)throws ClienteNaoEncontradoException;
	
}
