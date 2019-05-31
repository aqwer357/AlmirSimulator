package pedidos;

import clientes.Cliente;

public class RepositorioPedidosArray implements RepositorioPedidos {
	private Pedido[] arrayPedidos;
	private int codigo;

	public RepositorioPedidosArray() {	
		
		arrayPedidos = new Pedido[1000];
		codigo = 0;
	}

	public void inserir(Pedido pedido) {

		arrayPedidos[codigo] = pedido;
		codigo++;
	}

	public String procurar(Cliente cliente) throws PedidoNaoEncontradoException {

		for (int i = 0; i < 1000; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					return this.arrayPedidos[i].getCliente().getNome() + this.arrayPedidos[i].getPedido();
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
					arrayPedidos[i] = null;
				}
			}
		}
	}

	public void atualizar(Cliente cliente, String novoPedido) throws PedidoNaoEncontradoException {

		for (int i = 0; i < 1000; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();
			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					this.arrayPedidos[i].setPedido(novoPedido);
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
