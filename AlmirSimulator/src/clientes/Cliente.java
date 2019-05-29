package clientes;

public class Cliente {

    private String nome;
    private String local;

    public Cliente(String nome, String local){
        this.nome = nome;
        this.local = local;
    }

    public String getNome(){
        return this.nome;
    }

    public String getLocal(){
        return this.local;
    }
}


