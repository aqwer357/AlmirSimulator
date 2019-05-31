package pedidos;

public class PedidoNaoExistenteException extends Exception {

	public PedidoNaoExistenteException() {
		super("Pedido nao existente no cardapio!");
	}
}
