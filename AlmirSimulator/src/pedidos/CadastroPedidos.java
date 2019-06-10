package pedidos;
import clientes.*;
import ingredientes.*;

public class CadastroPedidos {
	private RepositorioPedidos repositorio;
	private RepositorioIngredientes todosIngredientes;

	public CadastroPedidos(RepositorioPedidos repositorio, RepositorioIngredientes todosIngredientes) {
		this.repositorio = repositorio;				//Inicializa os repositorios na classe pedidos;
		this.todosIngredientes = todosIngredientes;
	}
	
	public void cadastrarPedido(Pedido pedido) throws IngredienteNaoEncontradoException {
		for(int i = 0; i < pedido.getTamanhoArray(); i++) { //Pega o tamanho do array de ingredientes do pedido;
			if(!todosIngredientes.existe(pedido.getRefeicao()[i])) { //Checa se o ingrediente existe no outro repositorio;
				throw new IngredienteNaoEncontradoException();
			}
		}
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