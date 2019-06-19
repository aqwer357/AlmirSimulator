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
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO INGREDIENTE
		try {
			almirA.removerIngrediente("Sushi");
			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
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
			System.out.println(e.getMessage() + "\n");
		}

		// Tentando cadastrar o mesmo fornecedor
		try {
			almirA.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarFornecedor(carnes);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarFornecedor(especiais);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarFornecedor(sonho);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOCAO DE FORNECEDORES
		try {

			almirA.removerFornecedor(104);
			System.out.println("Fornecedor(es) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
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
			System.out.println(e.getMessage() + "\n");
		}

		// LISTA DE CLIENTES

		Cliente cliente1 = new Cliente("Thayna", "CIn", 0);
		Pedido pedido1 = new Pedido(cliente1,
				new String[] { "Arroz branco", "Feijao mulatinho", "Frango a parmegiana" }, false);

		Cliente cliente2 = new Cliente("Fabiano", "CCEN", 1);
		Pedido pedido2 = new Pedido(cliente2, new String[] { "Macarrao", "Pure de batatas", "Carne" }, false);

		Cliente cliente3 = new Cliente("Jean", "CFCH", 2);
		Pedido pedido3 = new Pedido(cliente3, new String[] { "Lasanha" }, true);

		Cliente cliente4 = new Cliente("Sergio", "CIn", 3);
		Pedido pedido4 = new Pedido(cliente4, new String[] { "Lasanha", "Frango a parmegiana" }, true);

		Cliente cliente5 = new Cliente("Ricardo", "CCEN", 4);
		Pedido pedido5 = new Pedido(cliente5, new String[] { "Lasanha" }, false);

		Cliente cliente5Atualizar = new Cliente("Ricardo", "CIn", 4);

		Cliente cliente6 = new Cliente("Sr. Removido", "Lugar nenhum", 5);
		Pedido pedido6 = new Pedido(cliente6, new String[] { "Lasanha" }, false);

		// CADASTRA OS PEDIDOS + CLIENTES
		try {
			almirA.cadastrarCliente(cliente1);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente2);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente3);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente4);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente4);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente5);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarCliente(cliente6);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO E ATUALIZANDO CLIENTES

		try {
			almirA.removerCliente("Sr. Removido");
			System.out.println("Cliente(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.atualizarClientes(cliente5Atualizar);
			System.out.println("Cliente(s) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// CADASTRA OS PEDIDOS
		try {
			almirA.cadastrarPedido(pedido1);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		try {
			almirA.cadastrarPedido(pedido2);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		try {
			almirA.cadastrarPedido(pedido3);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		
		}
		try {
			System.out.println("O pedido do(a) "+ cliente3.getNome()+" é:");
			System.out.print(pedido3.printRefeicao());
			System.out.println("\n");
		
		}
		catch(Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPedido(pedido4);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPedido(pedido5);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPedido(pedido6);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// ATUALIZA PEDIDO ERRADO

		Pedido pedidoAtualizado = new Pedido(cliente1,
				new String[] { "Macarrao", "Feijao mulatinho", "Calabresa acebolada" }, false);

		try {
			almirA.atualizarPedido(cliente1, pedidoAtualizado);
			System.out.println("Pedido(s) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVE PEDIDO

		try {
			almirA.removerPedido(cliente6);
			System.out.println("Pedido(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		
		}
		//CHECA SE O METODO EXISTE (REP)
		try {
			almirA.obterPedido(cliente6);
			System.out.println("O(A)(s) cliente(s) está(ão) registrado(a)(s) no sistema.");
		
		}
		catch(Exception e){
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
			
		}

		// CRIANDO E CADASTRANDO PRATOS

		Prato prato1, prato2, prato4, prato5, prato4Atualizado;

		if (pedido1.getTipoPedido())
			prato1 = new PratoEspecial(pedido1.getCliente().getNome());
		else
			prato1 = new PratoComum(pedido1.getCliente().getNome());

		if (pedido2.getTipoPedido())
			prato2 = new PratoEspecial(pedido2.getCliente().getNome());
		else
			prato2 = new PratoComum(pedido2.getCliente().getNome());

		if (pedido4.getTipoPedido())
			prato4 = new PratoEspecial(pedido4.getCliente().getNome());
		else
			prato4 = new PratoComum(pedido4.getCliente().getNome());

		if (pedido5.getTipoPedido())
			prato5 = new PratoEspecial(pedido5.getCliente().getNome());
		else
			prato5 = new PratoComum(pedido5.getCliente().getNome());

		try {
			almirA.cadastrarPrato(prato1, pedido1);
			System.out.println("Prato cadastrado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPrato(prato2, pedido2);
			System.out.println("Prato cadastrado com sucesso.\n");
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPrato(prato4, pedido4);
			System.out.println("Prato cadastrado com sucesso.\n");
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.cadastrarPrato(prato5, pedido5);
			System.out.println("Prato cadastrado com sucesso.\n");
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// ATUALIZANDO UM PRATO

		prato4Atualizado = new PratoEspecial(pedido4.getCliente().getNome());

		try {
			prato4Atualizado.inserirIngrediente(ingredienteF31);
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirA.atualizarPratos(prato4Atualizado);
			System.out.println("Prato atualizado com sucesso.\n");
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO PRATO

		try {
			almirA.removerPrato("Sergio");
			System.out.println("Prato removido com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
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
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO INGREDIENTE
		try {
			almirL.removerIngrediente("Sushi");
			System.out.println("Ingrediente(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// CADASTRO DE FORNECEDORES
		try {
			
			almirL.cadastrarFornecedor(acompanhamentos);
			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// TENTANDO CADASTRAR FORNECEDOR
		
		try {
			almirL.cadastrarFornecedor(acompanhamentos);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarFornecedor(carnes);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarFornecedor(especiais);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarFornecedor(sonho);

			System.out.println("Fornecedor(es) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOCAO DE FORNECEDORES
		try {

			almirL.removerFornecedor(104);
			System.out.println("Fornecedor(es) removido(s) com sucesso.\n");

		} catch (FornecedorNaoEncontradoException | IngredienteNaoEncontradoException e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
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
			System.out.println(e.getMessage() + "\n");
		}

		// CADASTRA OS PEDIDOS + CLIENTES
		try {
			almirL.cadastrarCliente(cliente1);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarCliente(cliente2);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			almirL.cadastrarCliente(cliente3);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");
		}

		catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarCliente(cliente4);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarCliente(cliente5);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarCliente(cliente6);
			System.out.println("Cliente(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO E ATUALIZANDO CLIENTES

		try {
			almirL.removerCliente("Sr. Removido");
			System.out.println("Cliente removido com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.atualizarClientes(cliente5Atualizar);
			System.out.println("Cliente atualizado com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// CADASTRA OS PEDIDOS
		try {
			almirL.cadastrarPedido(pedido1);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		try {
			almirL.cadastrarPedido(pedido2);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		
		try {
			almirL.cadastrarPedido(pedido3);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		
		}
		//IMPRIME O PEDIDO DO CLIENTE		
		try {
			System.out.println("O pedido do(a) "+ cliente3.getNome()+" é:");
			System.out.print(pedido3.printRefeicao());
			System.out.println("\n");
		
		}
		catch(Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
		try {
			almirL.cadastrarPedido(pedido4);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarPedido(pedido5);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarPedido(pedido6);
			System.out.println("Pedido(s) cadastrado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// ATUALIZA PEDIDO

		try {
			almirL.atualizarPedido(cliente1, pedidoAtualizado);
			System.out.println("Pedido(s) atualizado(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVE PEDIDO

		try {
			almirL.removerPedido(cliente6);
			System.out.println("Pedido(s) removido(s) com sucesso.\n");

		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		
		}
		//CHECA SE O METODO EXISTE (REP)
		try {
			almirA.obterPedido(cliente6);
			System.out.println("O(A)(s) cliente(s) está(ão) registrado(a)(s) no sistema.");
		
		}
		catch(Exception e){
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
			
		}

		// CADASTRANDO PRATOS

		// PRATOS JA FORAM CRIADOS, MAS ESTOU REINICIALIZANDO ELES PARA TESTAR

		if (pedido1.getTipoPedido())
			prato1 = new PratoEspecial(pedido1.getCliente().getNome());		
		else
			prato1 = new PratoComum(pedido1.getCliente().getNome());
		
		if (pedido2.getTipoPedido())
			prato2 = new PratoEspecial(pedido2.getCliente().getNome());		
		else
			prato2 = new PratoComum(pedido2.getCliente().getNome());

		if (pedido4.getTipoPedido())
			prato4 = new PratoEspecial(pedido4.getCliente().getNome());		
		else
			prato4 = new PratoComum(pedido4.getCliente().getNome());

		if (pedido5.getTipoPedido())
			prato5 = new PratoEspecial(pedido5.getCliente().getNome());		
		else
			prato5 = new PratoComum(pedido5.getCliente().getNome());

		try {
			almirL.cadastrarPrato(prato1, pedido1);
			System.out.println("Prato cadastrado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarPrato(prato2, pedido2);
			System.out.println("Prato cadastrado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarPrato(prato4, pedido4);
			System.out.println("Prato cadastrado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.cadastrarPrato(prato5, pedido5);
			System.out.println("Prato cadastrado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// ATUALIZANDO UM PRATO

		prato4Atualizado = new PratoEspecial(pedido4.getCliente().getNome());

		try {
			prato4Atualizado.inserirIngrediente(ingredienteF31);
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		try {
			almirL.atualizarPratos(prato4Atualizado);
			System.out.println("Prato atualizado com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}

		// REMOVENDO PRATO

		try {
			almirL.removerPrato("Sergio");
			System.out.println("Prato removido com sucesso.\n");
			
		} catch (Exception e) {
			System.out.println("ERRO: ");
			System.out.println(e.getMessage() + "\n");
		}
	}

}
