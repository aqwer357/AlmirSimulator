package clientes;

public class RepositorioClienteLista implements RepositorioCliente{
    private Cliente cliente;
    private RepositorioClienteLista proximo;

    public RepositorioClienteLista(){
        this.cliente = null;
        this.proximo = null;
    }

    public void inserir(Cliente cliente){
        if(this.cliente == null){
            this.proximo = new RepositorioClienteLista();
            this.cliente = cliente;
        }
        else{
            this.proximo.inserir(cliente);
        }
    }
    
    public boolean existe(String nome) {
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				return true;
			} else {
				return proximo.existe(nome);
			}
		} else {
			throw new RuntimeException("Erro");
		}
	}
    
    public void remover(String nome) {
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new RuntimeException("Erro");
		}
	}
    
    public Cliente procurar(String nome) {
		if (this.cliente != null) {
			if (this.cliente.getNome().contentEquals(nome)) {
				return this.cliente;
			} else {
				return proximo.procurar(nome);
			}
		} else {
			throw new RuntimeException("Erro");
		}
	}
    
    public void atualizar(Cliente cliente){
    	Cliente clienteAlvo;
    	clienteAlvo = procurar(cliente.getNome());
    	this.remover(clienteAlvo.getNome());
    	this.inserir(cliente);
    }
    
    
}
