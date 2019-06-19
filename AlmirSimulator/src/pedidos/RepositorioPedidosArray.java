package pedidos;

import clientes.*;

public class RepositorioPedidosArray implements RepositorioPedidos {
	private Pedido[] arrayPedidos;
	private int codigo;

	public RepositorioPedidosArray() {
		arrayPedidos = new Pedido[1000];
		codigo = 0;
	}

	public void cadastrarPedido(Pedido pedido) {
		if (codigo == arrayPedidos.length - 1) {
			Pedido[] arrayPedidosNew = new Pedido[arrayPedidos.length * 2];

			for (int i = 0; i < arrayPedidos.length - 1; i++) { // ArrayDinamico;
				arrayPedidosNew[i] = arrayPedidos[i];
			}

			arrayPedidos = arrayPedidosNew;
			codigo++;
			arrayPedidos[codigo] = pedido;

		} else {
			arrayPedidos[codigo] = pedido;
			codigo++;
		}
	}

	public Pedido obterPedido(Cliente cliente) {
		for (int i = 0; i < codigo; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				return this.arrayPedidos[i];
			}
		}
		return null;
	}

	public void removerPedido(Cliente cliente) {
		int index = cliente.getCodigoCliente();
		
		if(this.arrayPedidos.length -1 >= index) { // Reorganizando os clientes no array.
			System.arraycopy(arrayPedidos, index + 1, this.arrayPedidos, index, this.arrayPedidos.length -1 - index);
		}
		this.arrayPedidos[this.arrayPedidos.length - 1] = null;
		this.codigo--;
	}

	public void atualizarPedido(Cliente cliente, Pedido novoPedido) {
		for (int i = 0; i < codigo; i++) {
			
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				this.arrayPedidos[i] = novoPedido; // Troca o pedido do cliente;
				
			}
		}
	}

	public boolean existePedido(Cliente cliente) {
		for (int i = 0; i < codigo; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				return true;
			}
		}
		return false;
	}
}