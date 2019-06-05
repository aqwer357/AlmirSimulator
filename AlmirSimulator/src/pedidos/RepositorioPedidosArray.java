package pedidos;

import java.lang.reflect.Array;

import clientes.Cliente;

public class RepositorioPedidosArray implements RepositorioPedidos {
	private Pedido[] arrayPedidos;
	private int codigo;

	public RepositorioPedidosArray() {

		arrayPedidos = new Pedido[1000];
		codigo = 0;
	}

	public void inserir(Pedido pedido) {
		if (codigo == arrayPedidos.length - 1) {
			Pedido[] arrayPedidosNew = new Pedido[arrayPedidos.length * 2];

			for (int i = 0; i < arrayPedidos.length - 1; i++) { // ArrayDinamico;
				arrayPedidosNew[i] = arrayPedidos[i];
			}

			arrayPedidos = arrayPedidosNew;
			codigo++;
			arrayPedidos[codigo] = pedido;

		} else {
			codigo++;
			arrayPedidos[codigo] = pedido;
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

	public void remover(Cliente cliente) {

		for (int i = 0; i < arrayPedidos.length - 1; i++) {

			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {

				for (int j = cliente.getCodigoCliente(); j < arrayPedidos.length - 1; j++) { // Reorganiza o array!
					this.arrayPedidos[j] = this.arrayPedidos[j + 1];
				}
				this.arrayPedidos[arrayPedidos.length - 1] = null;

			}
		}
	}

	public void atualizar(Cliente cliente, Pedido novoPedido) {
		boolean trocaRealizada = false;

		for (int i = 0; i < arrayPedidos.length - 1 && !trocaRealizada; i++) {

			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				this.arrayPedidos[i] = novoPedido; // Troca o pedido do cliente;
				trocaRealizada = true;
			}
		}
	}

	public boolean existe(Cliente cliente) {
		boolean achou = false;

		for (int i = 0; i < arrayPedidos.length - 1 && !achou; i++) {
			if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				achou = true;
			}
		}
		return achou;
	}
}