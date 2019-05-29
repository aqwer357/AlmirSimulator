package pratos;

public interface RepositorioPratos {
	void inserir(Prato prato) throws PJFIException;
	
	void atualizar(Prato prato);
	
	void remover(int codigo) throws PNEException;
	
	Prato procurar(int codigo);
	
	boolean existe(int codigo);
	
}
