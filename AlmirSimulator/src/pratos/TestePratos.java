package pratos;

import clientes.Cliente;
import ingredientes.*;
import pedidos.*;

public class TestePratos {

	public static void main(String[] args) throws IIException, PJFIException, IngredienteNaoEncontradoException {
		
		Ingrediente arroz = new Ingrediente("Arroz branco", false), omelete = new Ingrediente("Omelete", true),
				frangoParmegiana = new Ingrediente("Frango a parmegiana", false);
		
		RepositorioIngredientes repIng = new RepositorioIngredientesLista();
		
		repIng.inserir(arroz);
		repIng.inserir(omelete);
		repIng.inserir(frangoParmegiana);
		
		Prato teste1 = new PratoComum("Bob");
		
		teste1.inserirIngrediente(arroz);
		
		RepositorioPratos repPra = new RepositorioPratosArray();
		CadastroPratos cadPra = new CadastroPratos(repPra);
		
		Prato teste2 = new PratoEspecial("Bobert"), teste3 = new PratoComum("Zeh");
		
		Cliente bobert = new Cliente("Bobert", "CIn", 88769);
		
		Pedido pedido = new Pedido(new String[] {"Arroz branco", "Frango a parmegiana", "Omelete"}, bobert, "Especial");
		
		cadPra.inserir(teste2, pedido, repIng);
		
		cadPra.inserir(teste3, pedido, new RepositorioIngredientesArray());
	}

}
