package pedidos;
import clientes.Cliente;

public class RepositorioPedidosArray implements RepositorioPedidos {
    private Pedido[] pedidos;
    private int codigo;

    public RepositorioPedidosArray(){
        pedidos = new Pedido[1000];
        codigo = 0;
    }

    public void inserir(Pedido pedido) {
        pedidos[codigo] = pedido;
        codigo++;
    }

    public String procurar(Cliente cliente) throws PedidoNaoEncontradoException {
        for(int i = 0; i < 1000; i++) {
        	if(pedidos[i] == null) {
        		throw new PedidoNaoEncontradoException();
        	}
        	else {
        		if(this.pedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
        			return this.pedidos[i].getPedido();
        		}
        	}
        }
        throw new PedidoNaoEncontradoException();
    }

    public void remover(String numero) throws PedidoNaoEncontradoException {

    }

    public void atualizar(Pedido pedido) throws PedidoNaoEncontradoException {

    }

}

