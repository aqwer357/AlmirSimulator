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
			throw new LimiteAtingidoException();
		}
		
	}
	
	public void remover(String nome) throws ClienteNaoEncontradoException{
		int index = this.getIndice(nome);
		if(this.arrayCliente.length -1 >= index) { // Reorganizando os clientes no array.
			System.arraycopy(arrayCliente, index + 1, this.arrayCliente, index, this.arrayCliente.length -1 - index);
		}
		this.arrayCliente[this.arrayCliente.length - 1] = null;
		this.indice--;
	}

	public boolean existe(String nome){
		for(int i = 0 ; i < this.indice ; i++) {
			if(this.arrayCliente[i].getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public Cliente procurar(String nome) throws ClienteNaoEncontradoException{
		Cliente retorno = null;
		boolean encontrou = false;
		for(int i = 0 ; i < this.indice && !encontrou; i ++) {
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
		int index = this.getIndice(cliente.getNome());
		arrayCliente[index] = cliente;
	}
	
	// método auxiliar que retorna o indice de um determinado cliente no array. Esse método existe apenas para tornar o código mais legivel e claro.
	private int  getIndice(String nome) throws ClienteNaoEncontradoException{ 
		int indice_retorno = 0;
		boolean encontrou_cliente = false;
		for(int i = 0 ; i < this.indice ; i++) {
			if(this.arrayCliente[i].getNome().equals(nome)) {
				indice_retorno = i;
				encontrou_cliente = true;
			}
		}
		if(encontrou_cliente) {
			return indice_retorno;
		}
		else {
			throw new ClienteNaoEncontradoException();
		}
		
	}
	
	
	
	
	
	

}
