package pedidos;
import clientes.*;

public class RepositorioPedidosLista implements RepositorioPedidos {
	private Pedido pedido;
	private RepositorioPedidosLista proximo;

	public RepositorioPedidosLista() {
		this.pedido = null;
		this.proximo = null;
	}

	public void cadastrarPedido(Pedido pedido) {
		if (this.pedido == null) {
			this.pedido = pedido;
			this.proximo = new RepositorioPedidosLista();

		} else {
			this.proximo.cadastrarPedido(pedido);
		}
	}

	public Pedido obterPedido(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			return this.pedido;

		} else {
			return this.proximo.obterPedido(cliente);
		}
	}

	public void atualizarPedido(Cliente cliente, Pedido novoPedido) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			this.pedido = novoPedido;

		} else {
			this.proximo.atualizarPedido(cliente, novoPedido);
		}
	}

	public void removerPedido(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			this.pedido = this.proximo.pedido;
			this.proximo = this.proximo.proximo;

		} else {
			this.proximo.removerPedido(cliente);
		}
	}

	public boolean existePedido(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			return true;

		} else {
			return this.proximo.existePedido(cliente);
		}
	}
}
