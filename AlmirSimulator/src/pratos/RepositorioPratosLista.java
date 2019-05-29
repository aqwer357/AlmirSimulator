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

	public void remover(int codigo) throws PNEException {
		if (this.prato.getCodigo() == codigo) {
			this.prato = this.proximo.prato;
			this.proximo = this.proximo.proximo;
		} else if (this.proximo == null)
			throw new PNEException();
		else
			this.proximo.remover(codigo);
	}

	public Prato procurar(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existe(int codigo) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
