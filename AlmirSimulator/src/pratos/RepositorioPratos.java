package pratos;

public interface RepositorioPratos {
	void inserir(Prato prato);
	
	void atualizar(Prato prato);
	
	void remover(int codigoPrato);
	
	Prato procurar(int codigoPrato);
	
	boolean existe(int codigoPrato);
	
	int getCodigo();
	
}
