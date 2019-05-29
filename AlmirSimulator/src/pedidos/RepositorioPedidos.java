package pedidos;

public interface RepositorioPedidos {

    void inserir(Pedido pedido) throw PedidoNaoExistenteException;
    Pedido procurar(String refeicao) throws PedidoNaoEncontradoException; //getPedido
    void atualizar(Pedido pedido) throws PedidoNaoEncontradoException;	//setPedido

}
