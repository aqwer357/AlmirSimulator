package pratos;

public class RepositorioPratosLista implements RepositorioPratos {

	private Prato prato;
	private RepositorioPratosLista proximo;
	
	public RepositorioPratosLista() {
		this.prato = null;
		this.proximo = null;
	}

	public void inserir(Prato prato) throws PJFIException {
		if (this.prato == null) {
			this.prato = prato;
			this.proximo = new RepositorioPratosLista();
		} else if (this.prato == prato)
			throw new PJFIException();
		else
			proximo.inserir(prato);
	}

	public void atualizar(Prato prato) {
		// TODO Auto-generated method stub
		
	}

	public void remover(int codigoPrato) throws PNEException {
		if (this.prato.getCodigo() == codigoPrato) {
			this.prato = this.proximo.prato;
			this.proximo = this.proximo.proximo;
		} else if (this.proximo == null)
			throw new PNEException();
		else
			this.proximo.remover(codigoPrato);
	}

	public Prato procurar(int codigoPrato) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existe(int codigoPrato) {
		if (this.prato.getCodigo() == codigoPrato)
			return true;
		else if (this.proximo == null)
			return false;
		else
			return this.proximo.existe(codigoPrato);
	}
	
}
