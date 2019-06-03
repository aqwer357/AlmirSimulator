package pedidos;

import clientes.Cliente;

public class RepositorioPedidosLista implements RepositorioPedidos{
	private Pedido pedido;
	private RepositorioPedidosLista proximo;
	
	public RepositorioPedidosLista() {
		this.pedido = null;
		this.proximo = null;
	}
	
	public void inserir(Pedido pedido) {
		if(this.pedido == null) {
			this.pedido = pedido;
			this.proximo = new RepositorioPedidosLista();
		}
		else {
			this.proximo.inserir(pedido);
		}		
	}
	
	public Pedido procurar(Cliente cliente) throws PedidoNaoEncontradoException{
		if(this.pedido == null) {
			throw new PedidoNaoEncontradoException(); 
		}
		
		else {
			if(this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				return this.pedido;
			}
			else {
				return this.proximo.procurar(cliente);
			}
		}
	}
	public void atualizar(Cliente cliente, Pedido novoPedido) throws PedidoNaoEncontradoException {
		if(this.pedido == null) {
			throw new PedidoNaoEncontradoException();
		}
		else {
			if(this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				this.pedido = novoPedido;
			}
			else {
				this.proximo.atualizar(cliente, novoPedido);
			}
		}
	}
	public void remover(Cliente cliente) throws PedidoNaoEncontradoException {
		if(this.pedido == null) {
			throw new PedidoNaoEncontradoException();
		}
		else {
			if(this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				this.pedido = this.proximo.pedido;
				this.proximo = this.proximo.proximo;
			}
			else {
				this.proximo.remover(cliente);
			}
		}
	}
	public boolean existe(Cliente cliente) {
		if(this.pedido == null) {
			return false;
		}
		else {
			if(this.pedido.getCliente().getCodigoCliente() == cliente.getCodigoCliente()) {
				return true;
			}
			else {
				return this.proximo.existe(cliente);
			}
		}
	}
}
