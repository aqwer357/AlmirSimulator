package programa;

import clientes.*;
import fachada.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import fornecedores.*;

import java.util.*;

public class Programa {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Almir almirLista = new Almir(new RepositorioFornecedoresLista(), new RepositorioIngredientesLista(), new RepositorioPedidosLista(),
				new RepositorioPratosLista(), new RepositorioClientesLista()),
			  almirArray = new Almir(new RepositorioFornecedoresArray(), new RepositorioIngredientesArray(), new RepositorioPedidosArray(),
						new RepositorioPratosArray(), new RepositorioClientesArray());
		
		System.out.printf("Insira a quantidade de fornecedores:");
		
		int quantFornecedores = in.nextInt();
		
		for (int i = 0; i < quantFornecedores; i++) {
			RepositorioIngredientesArray ingredientesFornecedor = new RepositorioIngredientesArray();
			
			System.out.printf("\n\nQual o nome do fornecedor?");
			String nomeFornecedor = in.nextLine();
			
			System.out.printf("Quantos ingredientes ele fornece?");
			int quantIngredientes = in.nextInt();
			
			for (int j = 0; j < quantIngredientes; i++) {
				System.out.printf("\nInsira o nome do ingrediente:");
				
			}
		}
	}

}
