package pedidos;

public class Pedido {
    private String[] refeicoes;
    private int contador;

    public Pedido(int quantidade) {
        this.refeicoes = new String[quantidade];
        contador = 0;
    }

    public void CadastrasPedidos(String pedido) throws PedidosOverFlowException {
        if (contador < this.cliente.getNumPedidos()) { //anti-corrupção;
            refeicoes[contador] = pedido;
            contador++;

        } else {
            PedidosOverFlowException erro = new PedidosOverFlowException();
            throw erro;
        }
    }
    public String getPedido(String cliente, String prato) throws PratoNaoEncontradoException{

    }
}
