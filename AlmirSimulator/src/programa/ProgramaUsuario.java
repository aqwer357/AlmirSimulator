package programa;

import clientes.*;
import fachada.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import fornecedores.*;

import java.util.*;

public class ProgramaUsuario {

	public static void main(String[] args) throws FornecedorJaCadastradoException, IngredienteJaCadastradoException {
		
		Scanner in = new Scanner(System.in);
		
		Almir almirLista = new Almir(new RepositorioFornecedoresLista(), new RepositorioIngredientesLista(), new RepositorioPedidosLista(),
				new RepositorioPratosLista(), new RepositorioClientesLista()),
				
			  almirArray = new Almir(new RepositorioFornecedoresArray(), new RepositorioIngredientesArray(), new RepositorioPedidosArray(),
						new RepositorioPratosArray(), new RepositorioClientesArray());
		
		System.out.printf("Insira a quantidade de fornecedores:");
		
		int quantFornecedores = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < quantFornecedores; i++) {
			RepositorioIngredientesArray ingredientesFornecedor = new RepositorioIngredientesArray();
			
			System.out.printf("\n\nQual o nome do fornecedor?");
			String nomeFornecedor = in.nextLine();
			
			System.out.printf("Quantos ingredientes ele fornece?");
			int quantIngredientes = in.nextInt();
			in.nextLine();
			boolean ehEspecial = false;
			
			for (int j = 0; j < quantIngredientes; j++) {
				System.out.printf("\nInsira o nome do ingrediente:");
				String nomeIngrediente = in.nextLine();
				
				System.out.printf("Eh especial? (responda com sim ou nao)");
				String especial = in.next();
				in.nextLine();
				
				if (especial.equalsIgnoreCase("sim"))
					ehEspecial = true;
				else
					ehEspecial = false;
				
				ingredientesFornecedor.inserir(new Ingrediente(nomeIngrediente, ehEspecial));
				
			}
			
			Fornecedor novoFornecedor = new Fornecedor(nomeFornecedor, ingredientesFornecedor, i);
			almirLista.cadastrarFornecedor(novoFornecedor);
			
			System.out.printf("\nFornecedor cadastrado.");
		}
	}

}
