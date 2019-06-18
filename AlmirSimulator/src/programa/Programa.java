package programa;

import clientes.*;
import fachada.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import fornecedores.*;

import java.util.*;

public class Programa {

	public static void main(String[] args) throws IngredienteNaoEncontradoException, FornecedorInvalidoException, LimiteAtingidoException {
		
		Scanner in = new Scanner(System.in);
		
		// SAIA. SAIA DO GRUPO AGORA
			
		RepositorioFornecedores fornecedores = new RepositorioFornecedoresArray();
		//RepositorioFornecedores fornecedores = new RepositorioFornecedoresLista();
		
		RepositorioIngredientes ingredientes = new RepositorioIngredientesArray();
		//RepositorioIngredientes ingredientes = new RepositorioIngredientesLista();
		
		RepositorioPedidos pedidos = new RepositorioPedidosArray();
		//RepositorioPedidos pedidos = new RepositorioPedidosLista();
		
		RepositorioPratos pratos = new RepositorioPratosArray();
		//RepositorioPratos pratos = new RepositorioPratosLista();
		
		RepositorioClientes clientes = new RepositorioClientesArray();
		//RepositorioClientes clientes = new RepositorioClientesLista();
		
		Almir almirA = new Almir(fornecedores, ingredientes, pedidos, pratos, clientes);
		//Almir almirL = new Almir(fornecedores, ingredientes, pedidos, pratos, clientes);
		
		
		RepositorioIngredientesArray ingredientesFornecedor1 = new RepositorioIngredientesArray();
		RepositorioIngredientesArray ingredientesFornecedor2 = new RepositorioIngredientesArray();
		
		Ingrediente ingredienteF11 = new Ingrediente("Arroz branco", false);
		Ingrediente ingredienteF12 = new Ingrediente("Feijao mulatinho", false);
		Ingrediente ingredienteF13 = new Ingrediente("Frango a parmegiana", false);
		
		Ingrediente ingredienteF21 = new Ingrediente("Macarrao", false);
		Ingrediente ingredienteF22 = new Ingrediente("Pure de batatas", false);
		Ingrediente ingredienteF23 = new Ingrediente("Calabresa acebolada", false);
		
		ingredientesFornecedor1.inserir(ingredienteF11);
		ingredientesFornecedor1.inserir(ingredienteF12);
		ingredientesFornecedor1.inserir(ingredienteF13);
		
		ingredientesFornecedor2.inserir(ingredienteF21);
		ingredientesFornecedor2.inserir(ingredienteF22);
		ingredientesFornecedor2.inserir(ingredienteF23);
		
		Fornecedor eu = new Fornecedor("aaaaa",ingredientesFornecedor1,100);
		Fornecedor tu = new Fornecedor("bbbbb",ingredientesFornecedor2,101);
		
		try{
			almirA.cadastrarFornecedor(eu);
			almirA.cadastrarFornecedor(tu);
			System.out.println("------Fornecedor cadastrado com sucesso------");
			System.out.println("------Ingredientes cadastrados com sucesso------");
			
		} catch (Exception e) {
			System.out.println("----------------- ERRO -----------------");
			System.out.println(e.getMessage()+ "\n\n");
		
		}	
		
		try {
			almirA.removerFornecedor(100);
			
		} catch (Exception e) {
			System.out.println("----------------- ERRO -----------------");
			System.out.println(e.getMessage()+ "\n\n");
		}
		
		
		
	}	

}
