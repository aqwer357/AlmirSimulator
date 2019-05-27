package pedidos;

public class RepositorioPedidosArray implements RepositorioPratos {
    private Pedido[] pedidos;
    private int codigo;

    public RepositorioPedidosArray(int tamanho){
        pedidos = new Pedido[tamanho];
        codigo = 0;
    }

    public void inserir(Pedido pedido) {
        pedidos[codigo].refeicoes = Pedido.;
        codigo++;
    }

    public Pedido procurar(String nome, String prato) throws PedidoNaoEncontradoException {
        Pedido resposta = null;
        String pessoa = this.getCodigo(nome);
    }

    public void remover(String numero) throws PedidoNaoEncontradoException {

    }

    public void atualizar(Pedido pedido) throws PedidoNaoEncontradoException {

    }
}
