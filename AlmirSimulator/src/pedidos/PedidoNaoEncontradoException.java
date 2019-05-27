package pedidos;

public class PedidoNaoEncontradoException extends Exception {

    public PedidoNaoEncontradoException(){
        super("Pedido não encontrado.");
    }
}
