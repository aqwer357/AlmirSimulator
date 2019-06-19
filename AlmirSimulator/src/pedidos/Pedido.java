package pedidos;
import clientes.*;

public class Pedido {
	private Cliente cliente;
	private String[] refeicao;
	private boolean tipoPedido; //TRUE: especial; FALSE: !especial;

	public Pedido(Cliente cliente, String[] refeicao, boolean tipoPedido) {
		this.cliente = cliente;
		this.refeicao = refeicao;
		this.tipoPedido = tipoPedido;
	}

	public void setPedido(String[] refeicao) { 		//MODIFICA A REFEICAO
		this.refeicao = refeicao;
	}
	
	public String printRefeicao() {				//IMPRIME A REFEICAO DO CLIENTE
		String resposta = "";
		
		for(String i: refeicao) {
			resposta += i + ", ";
		}
		return resposta.substring(0, resposta.length()-2);
	}

	public String[] getRefeicao() {			//RETORNA O OBJETO STRING[] REFEICAO
		return this.refeicao;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public int getTamanhoArray() {			//EH USADO NO CADASTRO DE PEDIDOS
		int tamanhoArray = refeicao.length;
		return tamanhoArray;
	}
	
	public boolean getTipoPedido() {		//EH USADO NA CLASSE PRATOS
		return this.tipoPedido;
	}
	
}
