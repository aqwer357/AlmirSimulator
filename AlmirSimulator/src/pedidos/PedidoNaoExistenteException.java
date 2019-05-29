package pedidos;

public class PedidoNaoExistenteException extends Exception {
	
	public PedidoNaoExistenteException(){
        super("Pedido não existente no cardápio!");
    }
}
