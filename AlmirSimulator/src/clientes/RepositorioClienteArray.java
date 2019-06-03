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
		boolean exists = false;
		int index = -1;
		for(int i = 0 ; i < this.arrayCliente.length ; i++) {
			if(this.arrayCliente[i].getNome().equals(nome)) {
				index = i;
				exists = true;
			}
		}
		if(this.arrayCliente.length -1 >= index) {
			System.arraycopy(arrayCliente, index + 1, this.arrayCliente,index, this.arrayCliente.length -1 - index);
		}
		this.arrayCliente[this.arrayCliente.length-1] = null;
		this.indice = this.indice - 1;
		
		if(!exists) {
			throw new ClienteNaoEncontradoException();
		}
		
	}

	public boolean existe(String nome){
		for(int i = 0 ; i < this.arrayCliente.length ; i++) {
			if(this.arrayCliente[i].getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public Cliente procurar(String nome) throws ClienteNaoEncontradoException{
		Cliente retorno = null;
		boolean encontrou = false;
		for(int i = 0 ; i< arrayCliente.length && !encontrou; i ++) {
			if(this.arrayCliente[i].getNome().equals(nome)) {
				retorno = this.arrayCliente[i];
				encontrou = true;
			}
		}
		if(encontrou) {
			return retorno;
		}
		else {
			throw new ClienteNaoEncontradoException();
		}
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		for(int i = 0 ; i < this.arrayCliente.length ; i++) {
			if(this.arrayCliente[i] == cliente) {
				int index = i;
			}
		}
		
	}
	
	
	
	
	
	

}
