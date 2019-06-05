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
			Pedido[] arrayPedidosNew = new Pedido[arrayPedidos.length * 2]; // O tamanho do array aumentará sempre que a
			for (int i = 0; i < arrayPedidos.length - 1; i++) {             // sua capacidade estiver cheia;
				arrayPedidosNew[i] = arrayPedidos[i];
			}

			arrayPedidos = arrayPedidosNew; // O antigo array recebe o novo array maior;
			codigo++;
			arrayPedidos[codigo] = pedido;

		} else {
			codigo++;
			arrayPedidos[codigo] = pedido;
		}
	}

	public Pedido procurar(Cliente cliente) throws PedidoNaoEncontradoException {

		for (int i = 0; i < arrayPedidos.length - 1; i++) {
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

		for (int i = 0; i < arrayPedidos.length - 1; i++) {
			if (arrayPedidos[i] == null) { // Se chegar ao null, significa que chegou ao fim dos cadastros ate o
										   // momento.
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {

					for (int j = cliente.getCodigoCliente(); j < arrayPedidos.length - 1; j++) {// reorganiza o array!
						this.arrayPedidos[j] = this.arrayPedidos[j + 1];
					}
					this.arrayPedidos[arrayPedidos.length] = null; // Ao remover um pedido, claramente a ultima posicao
																   // do array será nula, haja vista que um pedido foi apagado;
				}
			}
		}
	}

	public void atualizar(Cliente cliente, Pedido novoPedido) throws PedidoNaoEncontradoException {
		boolean trocaRealizada = false;

		for (int i = 0; i < arrayPedidos.length - 1 && !trocaRealizada; i++) {
			if (arrayPedidos[i] == null) {
				throw new PedidoNaoEncontradoException();

			} else {
				if (this.arrayPedidos[i].getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
					this.arrayPedidos[i] = novoPedido; // Troca o prato pedido pelo cliente;
					trocaRealizada = true;
				}
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