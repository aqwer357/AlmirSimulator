package pedidos;
import clientes.*;

public class Pedido {
	private Cliente cliente;
	private String[] refeicao;
	private boolean tipoPedido; //True: especial; False: !especial;

	public Pedido(Cliente cliente, String[] refeicao, boolean tipoPedido) {
		this.cliente = cliente;
		this.refeicao = refeicao;
		this.tipoPedido = tipoPedido;
	}

	public void setPedido(String[] refeicao) {
		this.refeicao = refeicao;
	}
	
	public String printRefeicao() {
		String resposta = "";
		for(String i: refeicao) {
			resposta += i + ", ";
		}
		return resposta.substring(0, resposta.length()-2);
	}

	public String[] getRefeicao() {
		return this.refeicao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getTamanhoArray() {
		int tamanhoArray = refeicao.length;
		return tamanhoArray;
	}
	
	public boolean getTipoPedido() {
		return this.tipoPedido;
	}
	
}
