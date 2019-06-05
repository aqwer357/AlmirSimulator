package pedidos;

import clientes.Cliente;

public class RepositorioPedidosLista implements RepositorioPedidos {

	private Pedido pedido;
	private RepositorioPedidosLista proximo;

	public RepositorioPedidosLista() {
		this.pedido = null;
		this.proximo = null;
	}

	public void inserir(Pedido pedido) {
		if (this.pedido == null) {
			this.pedido = pedido;
			this.proximo = new RepositorioPedidosLista();

		} else {
			this.proximo.inserir(pedido);
		}
	}

	public Pedido obterPedido(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			return this.pedido;

		} else {
			return this.proximo.obterPedido(cliente);
		}
	}

	public void atualizar(Cliente cliente, Pedido novoPedido) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			this.pedido = novoPedido;

		} else {
			this.proximo.atualizar(cliente, novoPedido);
		}
	}

	public void remover(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			this.pedido = this.proximo.pedido;
			this.proximo = this.proximo.proximo;

		} else {
			this.proximo.remover(cliente);
		}
	}

	public boolean existe(Cliente cliente) {
		if (this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
			return true;

		} else {
			return this.proximo.existe(cliente);
		}
	}
}
