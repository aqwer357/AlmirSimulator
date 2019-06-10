package pratos;

public interface RepositorioPratos {
	void inserir(Prato prato);
	
	void atualizar(Prato prato);
	
	void remover(String nome);
	
	Prato procurar(String nome);
	
	boolean existe(String nome);
	
	int getCodigo();
	
}
