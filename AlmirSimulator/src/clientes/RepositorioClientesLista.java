package clientes;

public class RepositorioClientesLista implements RepositorioClientes{
    private Cliente cliente;
    private RepositorioClientesLista proximo;

    public RepositorioClientesLista(){
        this.cliente = null;
        this.proximo = null;
    }

    public void inserir(Cliente cliente){
        if(this.cliente == null){
            this.proximo = new RepositorioClientesLista();
            this.cliente = cliente;
        }
        else{
            this.proximo.inserir(cliente);
        }
    }
    
    public boolean existe(String nome){
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				return true;
			} else {
				return proximo.existe(nome);
			}
		} else {
			return false;
		}
	}
    
    public void remover(String nome) throws ClienteNaoEncontradoException{
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
    
    public Cliente procurar(String nome) throws ClienteNaoEncontradoException{
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				return this.cliente;
			} else {
				return proximo.procurar(nome);
			}
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}
    
    public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
    	Cliente clienteAlvo;
    	clienteAlvo = procurar(cliente.getNome());
    	this.remover(clienteAlvo.getNome());
    	this.inserir(cliente);
    }
    
    
    
    
}
