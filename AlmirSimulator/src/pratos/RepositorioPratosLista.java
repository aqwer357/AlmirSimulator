package pratos;

public class RepositorioPratosLista implements RepositorioPratos {

	private Prato prato;
	private RepositorioPratosLista proximo;
	private int codigo; 
	
	// codigo serve como identificador para cada prato inserido no repositorio, o primeiro prato eh o prato 1,
	// o segundo eh o 2, o n-esimo eh n
	
	public RepositorioPratosLista() {
		this.prato = null;
		this.proximo = null;
		this.codigo = 0;
	}

	public void inserir(Prato prato) {
		if (this.prato == null) {
			this.prato = prato;
			this.proximo = new RepositorioPratosLista();
			codigo++;
		} else
			proximo.inserir(prato);
	}

	public void atualizar(Prato pratoNovo) throws PNEException {
		if (pratoNovo.getCodigo() == this.prato.getCodigo()) {
			this.prato = pratoNovo;
		} else if (this.proximo.prato == null)
			throw new PNEException();
		else
			this.proximo.atualizar(pratoNovo);
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

	public Prato procurar(int codigoPrato) throws PNEException {
		if (this.prato.getCodigo() == codigoPrato)
			return this.prato;
		else if (this.proximo.prato == null)
			throw new PNEException();
		else
			return this.proximo.procurar(codigoPrato);
		}

	public boolean existe(int codigoPrato) {
		if (this.prato.getCodigo() == codigoPrato)
			return true;
		else if (this.proximo == null)
			return false;
		else
			return this.proximo.existe(codigoPrato);
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
