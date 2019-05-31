package pedidos;

import clientes.Cliente;

public interface RepositorioPedidos {

	public void inserir(Pedido pedido) throws PedidoNaoExistenteException, LimiteAtingidoException;

	public String procurar(Cliente cliente) throws PedidoNaoEncontradoException; // getPedido

	public void atualizar(Cliente cliente, String refeicao) throws PedidoNaoEncontradoException; // setPedido

	public void remover(Cliente cliente) throws PedidoNaoEncontradoException;

	public boolean existe(Cliente Cliente);
	
}
