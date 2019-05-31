package pedidos;

public interface RepositorioPedidos {

    void inserir(Pedido pedido) throws PedidoNaoExistenteException;
    Pedido procurar(int codigo) throws PedidoNaoEncontradoException; //getPedido
    void atualizar(int codigo, String refeicao) throws PedidoNaoEncontradoException;	//setPedido
    void remover(int codigo);
    
}
