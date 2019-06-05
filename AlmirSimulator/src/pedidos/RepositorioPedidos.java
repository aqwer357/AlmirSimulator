package pedidos;
import clientes.*;

public interface RepositorioPedidos {

	public void cadastrarPedido(Pedido pedido);

	public Pedido obterPedido(Cliente cliente); // getPedido

	public void atualizarPedido(Cliente cliente, Pedido novoPedido); // setPedido

	public void removerPedido(Cliente cliente);

	public boolean existePedido(Cliente Cliente);

}