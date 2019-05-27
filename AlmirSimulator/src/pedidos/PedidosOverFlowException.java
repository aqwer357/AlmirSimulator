package pedidos;

public class PedidosOverFlowException extends Exception {

    public PedidosOverFlowException(){
        super("Pedido(s) finalizado(s).");
    }
}
