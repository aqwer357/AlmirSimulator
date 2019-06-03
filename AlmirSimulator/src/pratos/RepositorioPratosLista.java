package pratos;

public class RepositorioPratosLista implements RepositorioPratos {

	private Prato prato;
	private RepositorioPratosLista proximo;
	private int codigo; //sera o identificador de pratos, cada prato tera um codigo que incrementa o anterior
	
	public RepositorioPratosLista() {
		this.prato = null;
		this.proximo = null;
		this.codigo = 0;
	}

	public void inserir(Prato prato) throws PJFIException {
		if (this.prato == null) {
			this.prato = prato;
			this.proximo = new RepositorioPratosLista();
			codigo++;
		} else if (this.prato == prato)
			throw new PJFIException();
		else
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
