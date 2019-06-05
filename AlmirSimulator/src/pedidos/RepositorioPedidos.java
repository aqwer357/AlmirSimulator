package pedidos;

import clientes.Cliente;

public interface RepositorioPedidos {

	public void inserir(Pedido pedido);

	public Pedido obterPedido(Cliente cliente); // getPedido

	public void atualizar(Cliente cliente, Pedido novoPedido); // setPedido

	public void remover(Cliente cliente);

	public boolean existe(Cliente Cliente);

}
