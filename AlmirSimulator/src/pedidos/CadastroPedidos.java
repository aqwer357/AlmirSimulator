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
	public void inserir(Pedido pedido) throws LimiteAtingidoException{
		try {
			this.repositorio.inserir(pedido);
		
		}catch(LimiteAtingidoException e) {
			throw e;
		}
	}
}