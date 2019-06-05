package pedidos;
import clientes.*;

public class CadastroPedidos {
	private RepositorioPedidos repositorio;

	public CadastroPedidos(RepositorioPedidos repositorio) {// cria o repositorio conforme a necessidade;
		this.repositorio = repositorio;
	}
	
	public void cadastrarPedido(Pedido pedido) {
		this.repositorio.cadastrarPedido(pedido);
		
	}

	public void removerPedido(Cliente cliente) throws ClienteNaoEncontradoException {
		if (!repositorio.existePedido(cliente)) {
			throw new ClienteNaoEncontradoException();
		
		} else {
			this.repositorio.removerPedido(cliente);
		}
	}

	public Pedido obterPedido(Cliente cliente) throws ClienteNaoEncontradoException {
		if (!repositorio.existePedido(cliente)) {
			throw new ClienteNaoEncontradoException();
		
		}
		return this.repositorio.obterPedido(cliente);
	}

	public void atualizarPedido(Cliente cliente, Pedido novoPedido) throws ClienteNaoEncontradoException {
		if (!repositorio.existePedido(cliente)) {
			throw new ClienteNaoEncontradoException();
		
		} else {
			this.repositorio.atualizarPedido(cliente, novoPedido);
		}
	}

	public boolean existePedido(Cliente cliente) {
		return this.repositorio.existePedido(cliente);
	}
}