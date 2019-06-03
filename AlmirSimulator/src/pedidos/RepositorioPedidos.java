package pedidos;

import clientes.Cliente;

public interface RepositorioPedidos {

	public void inserir(Pedido pedido) throws LimiteAtingidoException;

	public Pedido procurar(Cliente cliente) throws PedidoNaoEncontradoException; // getPedido

	public void atualizar(Cliente cliente, Pedido novoPedido) throws PedidoNaoEncontradoException; // setPedido

	public void remover(Cliente cliente) throws PedidoNaoEncontradoException;

	public boolean existe(Cliente Cliente);
	
}
