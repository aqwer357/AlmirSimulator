package clientes;

public class ClienteMain {

	public static void main(String[] args) throws LimiteAtingidoException, ClienteNaoEncontradoException {
		
		Cliente cliente0 = new Cliente("Gabriel","CIn",0);
		
		RepositorioClientesArray repArray = new RepositorioClientesArray();
		
		RepositorioClientesLista repLista = new RepositorioClientesLista();
		
		// Testando o Repositorio Array
		
		System.out.println("Iniciando teste do repositorio array\n");
		
		repArray.inserir(cliente0);
		System.out.println(repArray.existe("Gabriel"));
		repArray.atualizar(cliente0);
		repArray.remover("Gabriel");
		System.out.println(repArray.existe("Gabriel"));
		repArray.inserir(cliente0);
		if(repArray.procurar("Gabriel") == cliente0) {
			System.out.println("O metodo procurar esta funcionando corretamente\n");
		}
		
		// Testando o Repositorio Lista
		
		System.out.println("Iniciando teste do repositorio array\n");
		
		repLista.inserir(cliente0);
		System.out.println(repLista.existe("Gabriel"));
		repLista.atualizar(cliente0);
		repLista.remover("Gabriel");
		System.out.println(repLista.existe("Gabriel"));
		repLista.inserir(cliente0);
		if(repLista.procurar("Gabriel") == cliente0) {
			System.out.println("O metodo procurar esta funcionando corretamente");
		}
		

	}

}
