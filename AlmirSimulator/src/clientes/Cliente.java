package clientes;

public class Cliente {

    private String nome;
    private String local;
    private int num_pedidos;

    public Cliente(String nome, String local, int num_pedidos){
        this.nome = nome;
        this.local = local;
        this.num_pedidos = num_pedidos;
    }

    public String getNome(){
        return this.nome;
    }

    public String getLocal(){
        return this.local;
    }

    public int getNumPedidos(){
        return this.num_pedidos;
    }




}


