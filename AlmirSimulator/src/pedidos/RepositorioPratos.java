package pedidos;

public interface RepositorioPratos {

    void inserir(Pedido pedido);
    Pedido procurar(String nome, String prato) throws PedidoNaoEncontradoException;
    void remover(String numero) throws PedidoNaoEncontradoException;
    void atualizar(Pedido pedido) throws PedidoNaoEncontradoException;

}
