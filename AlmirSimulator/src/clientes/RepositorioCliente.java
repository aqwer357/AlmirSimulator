package clientes;

public interface RepositorioCliente {

	boolean existe(String nome) throws ClienteNaoExistenteException;
	Cliente procurar(String nome);
	void inserir(Cliente cliente);
	void atualizar(Cliente cliente);
	void remover(String nome);
	
}
