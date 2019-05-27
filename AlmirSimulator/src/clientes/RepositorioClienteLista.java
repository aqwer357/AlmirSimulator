package clientes;

public class RepositorioClienteLista {
    private Cliente cliente;
    private RepositorioClienteLista next;

    public RepositorioClienteLista(){
        this.cliente = null;
        this.next = null;
    }

    public void insert(Cliente cliente){
        if(this.cliente == null){
            this.next = new RepositorioClienteLista();
            this.cliente = cliente;
        }
        else{
            this.next.insert(cliente);
        }
    }
    
    public boolean existe(Cliente cliente){
    	if(this.cliente == null) {
    		return false;
    	}
    	else{
    		if(this.cliente == cliente) {
    			return true;
    		}
    		else {
    			return this.next.existe(cliente);
    		}
    	}
    }
    
    public void remover(Cliente cliente) {
    	if(this.cliente.equals(cliente)) {
    		this.cliente = this.next.cliente;
    		this.next = this.next.next;
    	}
    	else {
    		this.next.remover(cliente);
    	}
    }
    
    
}
