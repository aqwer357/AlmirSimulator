package clientes;

public class Cliente {

	private String nome;
	private String local;
	private int codigoCliente;

	public Cliente(String nome, String local, int codigoCliente) {
		this.nome = nome;
		this.local = local;
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return this.nome;
	}

	public String getLocal() {
		return this.local;
	}

	public int getCodigoCliente() {
		return this.codigoCliente;
	}

}
