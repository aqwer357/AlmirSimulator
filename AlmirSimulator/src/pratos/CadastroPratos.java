package pratos;

public class CadastroPratos {
	private RepositorioPratos repositorio;
	
	public void inserir(Prato prato) throws PJFIException {
		if (repositorio.existe(prato.getCodigo()))
			throw new PJFIException();
		else
			this.repositorio.inserir(prato);
	}
	
	public void atualizar(Prato prato) throws PNEException {
		this.repositorio.atualizar(prato);
	}
	
	public void remover(int codigoPrato) throws PNEException {
		this.repositorio.remover(codigoPrato);
	}
	
	public Prato procurar(int codigoPrato) throws PNEException {
		return this.repositorio.procurar(codigoPrato);
	}
	
	public boolean existe(int codigoPrato) {
		return this.repositorio.existe(codigoPrato);
	}
}
