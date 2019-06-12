package pratos;

public class RepositorioPratosLista implements RepositorioPratos {

	private Prato prato;
	private RepositorioPratosLista proximo;
	
	// codigo serve como identificador para cada prato inserido no repositorio, o primeiro prato eh o prato 1,
	// o segundo eh o 2, o n-esimo eh n
	
	public RepositorioPratosLista() {
		this.prato = null;
		this.proximo = null;
	}

	public void inserir(Prato prato) {
		if (this.prato == null) {
			this.prato = prato;
			this.proximo = new RepositorioPratosLista();
		} else
			proximo.inserir(prato);
	}

	public void atualizar(Prato pratoNovo) {
		if (pratoNovo.getNome().equals(this.prato.getNome()))
			this.prato = pratoNovo;
		else
			this.proximo.atualizar(pratoNovo);
	}

	public void remover(String nome) {
		if (this.prato.getNome().equals(nome)) {
			this.prato = this.proximo.prato;
			this.proximo = this.proximo.proximo;
		} else
			this.proximo.remover(nome);
	}

	public Prato procurar(String nome) {
		if (this.prato.getNome().equals(nome))
			return this.prato;
		else
			return this.proximo.procurar(nome);
		}

	public boolean existe(String nome) {
		if (this.prato == null)
			return false;
		else if (this.prato.getNome().equals(nome))
			return true;
		else if (this.proximo == null)
			return false;
		else
			return this.proximo.existe(nome);
	}
	
}
