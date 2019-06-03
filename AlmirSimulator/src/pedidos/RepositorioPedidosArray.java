package pedidos;

import clientes.Cliente;

public class RepositorioPedidosArray implements RepositorioPedidos {
	private Pedido[] arrayPedidos;
	private int codigo;

	public RepositorioPedidosArray() {

		arrayPedidos = new Pedido[1000];
		codigo = 0;
	}

	public void inserir(Pedido pedido) throws LimiteAtingidoException {
		if(codigo < 999) {
			arrayPedidos[codigo] = pedido;
			codigo++;
		}
		else {
			throw new LimiteAtingidoException();
		}
	}

	public Pedido procurar(Cliente cliente) throws PedidoNaoEncontradoException {

		for (int i = 0; i < 1000; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					return this.arrayPedidos[i];
				}
			}
		}
		throw new PedidoNaoEncontradoException();
	}

	public void remover(Cliente cliente) throws PedidoNaoEncontradoException {

		for (int i = 0; i < 1000; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					for (int j = cliente.getCodigoCliente(); j < 999; j++) {// reorganiza o array!						
						this.arrayPedidos[j] = this.arrayPedidos[j + 1];
					}
					this.arrayPedidos[999] = null;						
				}
			}
		}
	}

	public void atualizar(Cliente cliente, Pedido novoPedido) throws PedidoNaoEncontradoException {
		boolean trocaRealizada = false;
		for (int i = 0; i < 1000 && !trocaRealizada; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					this.arrayPedidos[i] = novoPedido;
					trocaRealizada = true;
				}
			}
		}
	}

	public boolean existe(Cliente cliente) {
		boolean achou = false;

		for (int i = 0; i < 1000 && !achou; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				achou = true;
			}
		}
		return achou;
	}
}
