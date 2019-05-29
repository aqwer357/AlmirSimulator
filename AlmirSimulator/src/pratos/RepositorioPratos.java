package pratos;

public interface RepositorioPratos {
	void inserir(Prato prato) throws PJFIException;
	
	void atualizar(Prato prato);
	
	void remover(int codigoPrato) throws PNEException;
	
	Prato procurar(int codigoPrato);
	
	boolean existe(int codigoPrato);
	
}
