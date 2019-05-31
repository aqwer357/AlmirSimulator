package pedidos;

public class CadastroPedidos {
	private RepositorioPedidos pedido;

	public CadastroPedidos(boolean tipo) { // cria o repositorio conforme a necessidade;
		if (tipo == true) {
			pedido = new RepositorioPedidosArray();
		} else {
			pedido = new RepositorioPedidosLista();
		}
	}

}
