package pedidos;

public class Pedido {
	private Cliente cliente;
	private String[] refeicoes;
	private int contador;

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.refeicoes = new String[this.cliente.getNumPedidos()];
		contador = 0;
	}

	public void setPedido(String pedido) {
		if (contador < this.cliente.getNumPedidos()) { //anti-corrupção;
			refeicoes[contador] = pedido;
			contador++;
		} else {
			erro;
		}
	}
}
