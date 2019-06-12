package pratos;

import clientes.Cliente;
import ingredientes.*;
import pedidos.*;

public class TestePratos {

	public static void main(String[] args) throws IIException, PJFIException, IngredienteNaoEncontradoException, IngredienteJaCadastradoException {
		
		Ingrediente arroz = new Ingrediente("Arroz branco", false), omelete = new Ingrediente("Omelete", true),
				frangoParmegiana = new Ingrediente("Frango a parmegiana", false);
		
		CadastroIngredientes cadIng = new CadastroIngredientes(new RepositorioIngredientesArray());
		
		cadIng.cadastrar(arroz);
		cadIng.cadastrar(omelete);
		cadIng.cadastrar(frangoParmegiana);
		
		Prato teste1 = new PratoComum("Bob");
		
		teste1.inserirIngrediente(arroz);
		
		RepositorioPratos repPra = new RepositorioPratosArray();
		CadastroPratos cadPra = new CadastroPratos(repPra);
		
		Prato teste2 = new PratoEspecial("Bobert"), teste3 = new PratoComum("Zeh");
		
		Cliente bobert = new Cliente("Bobert", "CIn", 88769);
		
		Pedido pedido = new Pedido(bobert ,new String[] {"Arroz branco", "Frango a parmegiana", "Omelete"}, true);
		
		cadPra.inserir(teste2, pedido, cadIng);
		
		cadPra.inserir(teste3, pedido, new CadastroIngredientes(new RepositorioIngredientesLista()));
	}

}
