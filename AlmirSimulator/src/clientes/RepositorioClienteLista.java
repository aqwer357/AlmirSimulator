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


}
