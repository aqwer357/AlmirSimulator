package clientes;

public interface RepositorioCliente {

	boolean existe(String nome);
	Cliente procurar(String nome);
	void inserir(Cliente cliente);
	void atualizar(Cliente cliente);
	void remover(String nome);
	
}
