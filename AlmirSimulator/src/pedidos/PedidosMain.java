package pedidos;

import clientes.*;
import fachada.*;
import fornecedores.*;
import pratos.*;
import ingredientes.*;
import fachada.*;

public class PedidosMain {
	public static void main(String args[]) {
		
		Cliente cliente0 = new Cliente("Gustavo", "Cin", 0);
		RepositorioClienteArray clienteRep = new RepositorioClienteArray();
		
		Ingrediente ingrediente0 = new Ingrediente("Batata", true, false);
		RepositorioIngredientesArray ingredientesRep = new RepositorioIngredientesArray();
		ingredientesRep.inserir(ingrediente0);
		
		Pedido pedido0 = new Pedido(cliente0, new String[] {"batata"}, false);
		
		RepositorioPedidosArray pedidosRep = new RepositorioPedidosArray();
		
		pedidosRep.cadastrarPedido(pedido0);
		System.out.print(pedidosRep.existePedido(cliente0));
		
		pedidosRep.removerPedido(cliente0);
		System.out.print(pedidosRep.existePedido(cliente0));
		
		pedidosRep.atualizarPedido(cliente0, new Pedido(cliente0, new String[] {"arroz"}, false));
		System.out.println(pedidosRep.obterPedido(cliente0));
		
	}
}
