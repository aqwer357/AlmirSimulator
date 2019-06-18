package programa;

import clientes.*;
import fachada.*;
import ingredientes.*;
import pedidos.*;
import pratos.*;
import fornecedores.*;

import java.util.*;

public class Programa {

	public static void main(String[] args)
			throws IngredienteNaoEncontradoException, FornecedorInvalidoException, LimiteAtingidoException {

		Scanner in = new Scanner(System.in);

		// TESTE ARRAY

		RepositorioFornecedores fornecedoresArray = new RepositorioFornecedoresArray();
		RepositorioIngredientes ingredientesArray = new RepositorioIngredientesArray();
		RepositorioPedidos pedidosArray = new RepositorioPedidosArray();
		RepositorioPratos pratosArray = new RepositorioPratosArray();
		RepositorioClientes clientesArray = new RepositorioClientesArray();

		Almir almirA = new Almir(fornecedoresArray, ingredientesArray, pedidosArray, pratosArray, clientesArray);

		RepositorioIngredientesArray ingredientesFornecedor1 = new RepositorioIngredientesArray();
		RepositorioIngredientesArray ingredientesFornecedor2 = new RepositorioIngredientesArray();
		RepositorioIngredientesArray ingredientesFornecedor3 = new RepositorioIngredientesArray();
		RepositorioIngredientesArray ingredientesFornecedor4 = new RepositorioIngredientesArray();

		Ingrediente ingredienteF11 = new Ingrediente("Arroz integral", false);
		Ingrediente ingredienteF12 = new Ingrediente("Feijao mulatinho", false);
		Ingrediente ingredienteF13 = new Ingrediente("Feijao macassar", false);
		Ingrediente ingredienteF14 = new Ingrediente("Macarrao", false);

		Ingrediente ingredienteF21 = new Ingrediente("Frango a parmegiana", false);
		Ingrediente ingredienteF22 = new Ingrediente("Calabresa acebolada", false);
		Ingrediente ingredienteF23 = new Ingrediente("Bife a milanesa", false);

		Ingrediente ingredienteF31 = new Ingrediente("Lasanha", true);
		Ingrediente ingredienteF32 = new Ingrediente("Macaxeira com calabresa", true);

		Ingrediente ingredienteTeste1 = new Ingrediente("Sushi", true);
		Ingrediente ingredienteTeste2 = new Ingrediente("Arroz branco", false);

		// CADASTRO DE INGREDIENTES
		try {
			almirA.cadastrarIngrediente(ingredienteF11);
			almirA.cadastrarIngrediente(ingredienteF12);
			almirA.cadastrarIngrediente(ingredienteF13);
			almirA.cadastrarIngrediente(ingredienteF14);

			almirA.cadastrarIngrediente(ingredienteF21);
			almirA.cadastrarIngrediente(ingredienteF22);
			almirA.cadastrarIngrediente(ingredienteF23);

			almirA.cadastrarIngrediente(ingredienteF31);
			almirA.cadastrarIngrediente(ingredienteF32);

			almirA.cadastrarIngrediente(ingredienteTeste1);

			System.out.println("Ingrediente(s) cadastrado(s) com sucesso.\n");

		} catch (IngredienteJaCadastradoException e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// REMOVENDO INGREDIENTE
		try {
			almirA.removerIngrediente("Sushi");
			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		ingredientesFornecedor1.inserir(ingredienteF11);
		ingredientesFornecedor1.inserir(ingredienteF12);
		ingredientesFornecedor1.inserir(ingredienteF13);
		ingredientesFornecedor1.inserir(ingredienteF14);
		Fornecedor acompanhamentos = new Fornecedor("Emp1", ingredientesFornecedor1, 101);

		ingredientesFornecedor2.inserir(ingredienteF21);
		ingredientesFornecedor2.inserir(ingredienteF22);
		ingredientesFornecedor2.inserir(ingredienteF23);
		Fornecedor carnes = new Fornecedor("Emp2", ingredientesFornecedor2, 102);

		ingredientesFornecedor3.inserir(ingredienteF31);
		ingredientesFornecedor3.inserir(ingredienteF32);
		Fornecedor especiais = new Fornecedor("Emp3", ingredientesFornecedor3, 103);

		ingredientesFornecedor4.inserir(ingredienteTeste1);
		Fornecedor sonho = new Fornecedor("Emp4", ingredientesFornecedor4, 104);

		// CADASTRO DE FORNECEDORES
		try {
			almirA.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// Tentando cadastrar o mesmo fornecedor
		try {
			almirA.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirA.cadastrarFornecedor(carnes);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirA.cadastrarFornecedor(especiais);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirA.cadastrarFornecedor(sonho);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// REMOCAO DE FORNECEDORES
		try {

			almirA.removerFornecedor(104);
			System.out.println("Fornecedor(es) removido(s) com sucesso.\n");

		} catch (FornecedorNaoEncontradoException | IngredienteNaoEncontradoException e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// ATUALIZANDO FORNECEDORES + INGREDIENTES

		try {
			almirA.removerIngrediente("Arroz integral");
			almirA.cadastrarIngrediente(ingredienteTeste2);

			RepositorioIngredientesArray ingredientesAtualizados = new RepositorioIngredientesArray();

			ingredientesAtualizados.inserir(ingredienteTeste2);
			ingredientesAtualizados.inserir(ingredienteF12);
			ingredientesAtualizados.inserir(ingredienteF13);
			ingredientesAtualizados.inserir(ingredienteF14);

			Fornecedor fornecedorAtualizado = new Fornecedor("Emp1 2.0", ingredientesAtualizados, 101);

			almirA.atualizarFornecedor(fornecedorAtualizado);

			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");
			System.out.println("Ingrediente(s) cadastrado(s) com sucesso.\n");
			System.out.println("Fornecedor(es) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// LISTA DE CLIENTES

		Cliente cliente1 = new Cliente("Thayna", "CIn", 0);
		Pedido pedido1 = new Pedido(cliente1,
				new String[] { "Arroz branco", "Feijao mulatinho", "Frango a parmegiana" }, false);

		Cliente cliente2 = new Cliente("Fabiano", "CCEN", 1);
		Pedido pedido2 = new Pedido(cliente2, new String[] { "Macarrao", "Pure de batatas", "Carne" }, false);

		// CADASTRA OS PEDIDOS + CLIENTES
		try {
			almirA.cadastrarCliente(cliente1);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirA.cadastrarCliente(cliente2);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// CADASTRA OS PEDIDOS
		try {
			almirA.cadastrarPedido(pedido1);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}
		try {
			almirA.cadastrarPedido(pedido2);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// ATUALIZA PEDIDO ERRADO

		Pedido pedidoAtualizado = new Pedido(cliente1,
				new String[] { "Macarrao", "Feijao mulatinho", "Calabresa acebolada" }, false);

		try {
			almirA.atualizarPedido(cliente1, pedidoAtualizado);
			System.out.println("Pedido(s) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// TESTE LISTA
		RepositorioFornecedores fornecedoresLista = new RepositorioFornecedoresLista();
		RepositorioIngredientes ingredientesLista = new RepositorioIngredientesLista();
		RepositorioPedidos pedidosLista = new RepositorioPedidosLista();
		RepositorioPratos pratosLista = new RepositorioPratosLista();
		RepositorioClientes clientesLista = new RepositorioClientesLista();

		Almir almirL = new Almir(fornecedoresLista, ingredientesLista, pedidosLista, pratosLista, clientesLista);

		// CADASTRO DE INGREDIENTES
		try {
			almirL.cadastrarIngrediente(ingredienteF11);
			almirL.cadastrarIngrediente(ingredienteF12);
			almirL.cadastrarIngrediente(ingredienteF13);
			almirL.cadastrarIngrediente(ingredienteF14);

			almirL.cadastrarIngrediente(ingredienteF21);
			almirL.cadastrarIngrediente(ingredienteF22);
			almirL.cadastrarIngrediente(ingredienteF23);

			almirL.cadastrarIngrediente(ingredienteF31);
			almirL.cadastrarIngrediente(ingredienteF32);

			almirL.cadastrarIngrediente(ingredienteTeste1);

			System.out.println("Ingrediente(s) cadastrado(s) com sucesso.\n");

		} catch (IngredienteJaCadastradoException e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// REMOVENDO INGREDIENTE
		try {
			almirL.removerIngrediente("Sushi");
			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// CADASTRO DE FORNECEDORES
		try {
			almirL.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// Tentando cadastrar o mesmo fornecedor
		try {
			almirL.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirL.cadastrarFornecedor(carnes);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirL.cadastrarFornecedor(especiais);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirL.cadastrarFornecedor(sonho);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// REMOCAO DE FORNECEDORES
		try {

			almirL.removerFornecedor(104);
			System.out.println("Fornecedor(es) removido(s) com sucesso.\n");

		} catch (FornecedorNaoEncontradoException | IngredienteNaoEncontradoException e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// ATUALIZANDO FORNECEDORES + INGREDIENTES

		try {
			almirL.removerIngrediente("Arroz integral");
			almirL.cadastrarIngrediente(ingredienteTeste2);

			RepositorioIngredientesArray ingredientesAtualizados = new RepositorioIngredientesArray();

			ingredientesAtualizados.inserir(ingredienteTeste2);
			ingredientesAtualizados.inserir(ingredienteF12);
			ingredientesAtualizados.inserir(ingredienteF13);
			ingredientesAtualizados.inserir(ingredienteF14);

			Fornecedor fornecedorAtualizado = new Fornecedor("Emp1 2.0", ingredientesAtualizados, 101);

			almirL.atualizarFornecedor(fornecedorAtualizado);

			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");
			System.out.println("Ingrediente(s) cadastrado(s) com sucesso.\n");
			System.out.println("Fornecedor(es) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// CADASTRA OS PEDIDOS + CLIENTES
		try {
			almirL.cadastrarCliente(cliente1);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		try {
			almirL.cadastrarCliente(cliente2);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

		// CADASTRA OS PEDIDOS
		try {
			almirL.cadastrarPedido(pedido1);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}
		try {
			almirL.cadastrarPedido(pedido2);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// ATUALIZA PEDIDO ERRADO

		try {
			almirL.atualizarPedido(cliente1, pedidoAtualizado);
			System.out.println("Pedido(s) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n\n");
		}

	}

}
