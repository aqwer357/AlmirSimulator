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
		
		
		RepositorioIngredientesArray ingredientesFornecedor1 = new RepositorioIngredientesArray();
		
		
		Ingrediente ingrediente1 = new Ingrediente("Arroz", true, false);
		Ingrediente ingrediente2 = new Ingrediente("Feijao", true, false);
		Ingrediente ingrediente3 = new Ingrediente("Frango a Parmegiana", true, false);
		
		ingredientesFornecedor1.inserir(ingrediente1);
		ingredientesFornecedor1.inserir(ingrediente2);
		ingredientesFornecedor1.inserir(ingrediente3);
		
		Fornecedor eu = new Fornecedor("aaaaa",ingredientesFornecedor1,123);
		
	}

}
