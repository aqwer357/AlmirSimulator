package pedidos;

import clientes.Cliente;

public class CadastroPedidos {
	private RepositorioPedidos repositorio;

	public CadastroPedidos(RepositorioPedidos repositorio) {// cria o repositorio conforme a necessidade;
		this.repositorio = repositorio;
	}
	
	public void inserir(Pedido pedido) {
		this.repositorio.inserir(pedido);

	}

	public void remover(Cliente cliente) throws PedidoNaoEncontradoException {
		if (!repositorio.existe(cliente)) {
			throw new PedidoNaoEncontradoException();
		
		} else {
			this.repositorio.remover(cliente);
		}
	}

	public Pedido obterPedido(Cliente cliente) throws PedidoNaoEncontradoException {
		if (!repositorio.existe(cliente)) {
			throw new PedidoNaoEncontradoException();
		
		}
		return this.repositorio.obterPedido(cliente);
	}

	public void atualizar(Cliente cliente, Pedido novoPedido) throws PedidoNaoEncontradoException {
		if (!repositorio.existe(cliente)) {
			throw new PedidoNaoEncontradoException();
		
		} else {
			this.repositorio.atualizar(cliente, novoPedido);
		}
	}

	public boolean existe(Cliente cliente) {
		return this.repositorio.existe(cliente);
	}
}