package pratos;

import clientes.Cliente;

public interface RepositorioPratos {
	void inserir(Prato prato);
	
	void atualizar(Prato prato);
	
	void remover(int codigo);
	
	Prato procurar(int codigo);
	
	boolean existe(int codigo);
	
}
