package clientes;

public class RepositorioClienteArray implements RepositorioCliente {
	private Cliente[] arrayCliente;
	private int indice;
	
	public RepositorioClienteArray() {
		this.arrayCliente = new Cliente[1000];
		this.indice = 0;
	}
	
	public void inserir(Cliente cliente) throws LimiteAtingidoException {
		
		if(this.indice < this.arrayCliente.length) {
			this.arrayCliente[indice] = cliente;
			indice++;
		}
		else {
			LimiteAtingidoException exceção;
			exceção = new LimiteAtingidoException();
			throw exceção;
		}
		
	}
	
	public void remover(String nome) throws ClienteNaoEncontradoException{
		
	}

	public boolean existe(String nome) throws ClienteNaoEncontradoException {
		return false;
	}

	public Cliente procurar(String nome) {
		return null;
	}

	public void atualizar(Cliente cliente) {
		
		
	}
	
	
	
	
	
	

}
