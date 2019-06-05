package pedidos;
import clientes.*;

public class Pedido {
	private String refeicao;
	private Cliente cliente;

	public Pedido(String refeicao, Cliente cliente) {
		this.refeicao = refeicao;
		this.cliente = cliente;
	}

	public void setPedido(String refeicao) {
		this.refeicao = refeicao;
	}

	public String getPedido() {
		return this.refeicao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

}
