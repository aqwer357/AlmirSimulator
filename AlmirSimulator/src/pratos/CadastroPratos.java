package pratos;

public class CadastroPratos {
	private RepositorioPratos repositorio;
	
	public CadastroPratos(RepositorioPratos repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Prato prato) throws PJFIException {
		if (repositorio.existe(prato.getCodigo()))
			throw new PJFIException();
		else
			this.repositorio.inserir(prato);
	}
	
	public void atualizar(Prato prato) throws PNEException {
		if (!repositorio.existe(prato.getCodigo()))
			throw new PNEException();
		else
			this.repositorio.atualizar(prato);
	}
	
	public void remover(int codigoPrato) throws PNEException {
		if (!repositorio.existe(codigoPrato))
			throw new PNEException();
		else
			this.repositorio.remover(codigoPrato);
	}
	
	public Prato procurar(int codigoPrato) throws PNEException {
		if (!repositorio.existe(codigoPrato))
			throw new PNEException();
		else
			return this.repositorio.procurar(codigoPrato);
	}
	
	public boolean existe(int codigoPrato) {
		return this.repositorio.existe(codigoPrato);
	}
}
