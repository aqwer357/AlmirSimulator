package pedidos;
import clientes.*;

public class Pedido {
	private String[] refeicao;
	private Cliente cliente;
	private int tamanhoArray;
	private String tipoPedido;

	public Pedido(String[] refeicao, Cliente cliente, int quantidadeIngredientes, String tipoPedido) {
		this.refeicao = new String[quantidadeIngredientes];
		this.refeicao = refeicao;
		this.cliente = cliente;
		this.tamanhoArray = refeicao.length;
		this.tipoPedido = tipoPedido;
	}

	public void setPedido(String[] refeicao) {
		this.refeicao = refeicao;
	}

	public String[] getRefeicao() {
		return this.refeicao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getTamanhoArray() {
		return this.tamanhoArray;
	}
	
	public String getTipoPedido() {
		return this.tipoPedido;
	}
}
