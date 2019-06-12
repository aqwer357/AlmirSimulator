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
		for (int i = 0; i < arrayPedidos.length - 1; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				return this.arrayPedidos[i];
			}
		}
		return null;
	}

	public void removerPedido(Cliente cliente) {
		for (int i = 0; i < arrayPedidos.length - 1 && this.arrayPedidos[i] != null; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				int aux = 0;
				for (aux = cliente.getCodigoCliente(); this.arrayPedidos[aux] != null && aux < arrayPedidos.length - 1; aux++) { // Sobrepoe ate q a
																									// proxima posicao
																									// seja null;
					this.arrayPedidos[aux] = this.arrayPedidos[aux + 1];
				}
				this.arrayPedidos[aux] = null; // poe null na ultima posicao transferida;
			}
		}
	}

	public void atualizarPedido(Cliente cliente, Pedido novoPedido) {
		boolean trocaRealizada = false;

		for (int i = 0; i < arrayPedidos.length - 1 && !trocaRealizada; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				this.arrayPedidos[i] = novoPedido; // Troca o pedido do cliente;
				trocaRealizada = true;
			}
		}
	}

	public boolean existePedido(Cliente cliente) {
		boolean achou = false;

		for (int i = 0; i < arrayPedidos.length - 1 && !achou; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				achou = true;
			}
		}
		return achou;
	}
}