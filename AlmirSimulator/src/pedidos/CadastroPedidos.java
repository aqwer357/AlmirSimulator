package pedidos;

import clientes.Cliente;

public class CadastroPedidos {
	private RepositorioPedidos repositorio;

	public CadastroPedidos(boolean tipo) {// cria o repositorio conforme a necessidade;
		if (tipo) {
			this.repositorio = new RepositorioPedidosLista();
		} else {
			this.repositorio = new RepositorioPedidosArray();
		}
	}

	public void inserir(Pedido pedido) {
		this.repositorio.inserir(pedido);

	}	
	public void remover(Cliente cliente) throws PedidoNaoEncontradoException {
		if(!repositorio.existe(cliente)){
			throw new PedidoNaoEncontradoException();
		}
		else {
			repositorio.remover(cliente);
		}		
	}
}