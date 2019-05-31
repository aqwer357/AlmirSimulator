package clientes;

public class RepositorioClienteArray implements RepositorioCliente {
	private Cliente[] arrayCliente;
	private int indice;
	
	public RepositorioClienteArray() {
		this.arrayCliente = new Cliente[1000];
		this.indice = 0;
	}
	
	public void inserir(Cliente cliente) throws LimiteAtingidoException {
		
		if(this.indice < this.arrayCliente.length) { // verificando se ainda há espaço livre no array
			this.arrayCliente[indice] = cliente;
			indice++;
		}
		else {
			LimiteAtingidoException exceção;
			exceção = new LimiteAtingidoException();
			throw exceção;
		}
		
	}
	
	
	
	
	
	
	

}
